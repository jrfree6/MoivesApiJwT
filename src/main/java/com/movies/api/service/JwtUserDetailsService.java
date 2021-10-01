package com.movies.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movies.api.entity.UserEntity;
/**
 * 
 * @author jurandir
 *
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userService.getByUserName(userName);
		
		if(user.getUserName().equals(userName)) {
			return new User(userName, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found :"+ userName);
		}
		
		
	}


	
}
