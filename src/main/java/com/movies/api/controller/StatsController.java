package com.movies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.service.MoviesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jurandir
 *
 */

@RestController
@Api(value = "Stats")
@RequestMapping("/movies")
public class StatsController {
	
	@Autowired
	private MoviesService moviesService;
	
	@ApiOperation(value = "Quantity of movies by genre")
	@GetMapping( path = "/stats/ByGenre")
	@ResponseBody
	public ResponseEntity<Object> getStats() throws Exception {
		
		return ResponseEntity.status(HttpStatus.OK).body(moviesService.getTotalByGenre());
	}
	
	@ApiOperation(value = "Quantity of movies available")
	@GetMapping( path = "/stats/Available")
	@ResponseBody
	public ResponseEntity<Object> getAvailabel() throws Exception {
		
		return ResponseEntity.status(HttpStatus.OK).body(moviesService.getTotalAvailable());
	}

}
