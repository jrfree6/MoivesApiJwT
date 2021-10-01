package com.movies.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movies.api.entity.UserEntity;
import com.movies.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api(value = "User")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Create User")
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@Validated @RequestBody UserEntity user){
		
		UserEntity infoUser = userService.create(user);
		String message = "User saved sucessfully!!" + infoUser.getEmail() +" - "+ infoUser.getPassword();
		return ResponseEntity.ok(message);
	}
	
	@ApiOperation(value = "Get User")
	@GetMapping("/getUser")
	public ResponseEntity<List<UserEntity>> getUser(){
		
		List<UserEntity> infoUser = userService.getAll();
		return ResponseEntity.ok(infoUser);
	}
}
