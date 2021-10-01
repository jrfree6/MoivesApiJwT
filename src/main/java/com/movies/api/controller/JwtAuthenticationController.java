package com.movies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.config.JwtTokenUtil;
import com.movies.api.model.JwtRequest;
import com.movies.api.model.JwtResponse;
import com.movies.api.service.JwtUserDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jurandir
 *
 */
@Api(value = "Authenticate")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@ApiOperation(value = "Authenticate")
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("user jwt:" + authenticationRequest.getUserName());
		System.out.println("pass jwt:" + authenticationRequest.getPassword());
		
		
		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		//Validate username/password with DB(required in case of Stateless Authentication)
//		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//				authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
	
	private void authenticate(String userName, String passwd) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, passwd));
		} catch (DisabledException de) {
			throw new Exception("User disabled...");
		} catch (BadCredentialsException bde) {
			throw new Exception("Invalid Credentials...");
		}
	}

}
