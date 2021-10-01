package com.movies.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.movies.api.entity.UserEntity;
import com.movies.api.repository.UserRepository;
/**
 * 
 * @author jurandir
 *
 */

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity create(UserEntity user) {
		String generatedSecuredPasswordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(generatedSecuredPasswordHash);
		return userRepository.save(user);
	}
	
	public Optional<UserEntity> get(Long id) {
		return userRepository.findById(id);
	}
	
	public UserEntity getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public UserEntity getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}


	public List<UserEntity> getAll() {
		
		return userRepository.findAll();
	}
	
	
}
