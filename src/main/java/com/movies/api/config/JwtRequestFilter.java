package com.movies.api.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.movies.api.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
/**
 * 
 * @author jurandir
 *
 */

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String userName = null;
		String jwtToken = null;
		
		if( requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
//			jwtToken = requestTokenHeader.replace("Bearer", "");
			jwtToken = requestTokenHeader.substring(7);
			try {
				userName = jwtTokenUtil.getUserNameFromToken(jwtToken);
				
				System.out.println("jwt user:" + userName);
				
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch ( ExpiredJwtException ejw) {
				System.out.println("Token Expired..");
			}
		} else {
			logger.warn("Jwt token does not begin with Barer String...");
		}
		
		// Validar o token
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(userName);
			
			if(jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
			}
			
		}
		filterChain.doFilter(request, response);

	}

}
