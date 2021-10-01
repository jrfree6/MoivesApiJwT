package com.movies.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.entity.MovieEntity;
import com.movies.api.service.MoviesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author jurandir
 *
 */

@RestController
@Api(value = "Movies")
@RequestMapping("/movies")
public class MoviesController {
	
	
	@Autowired
	private MoviesService moviesService;
	
	@ApiOperation(value = "Create Movie")
	@PostMapping( path = "/saveMovie")
	@ResponseBody
	public ResponseEntity<String> createMovie(@Validated @RequestBody MovieEntity movies) throws Exception {
		
		MovieEntity movieEntity = moviesService.create(movies);
		String message = "Movie save sucessfully!! " + movieEntity.getId();
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@ApiOperation(value = "Delete Movie")
	@DeleteMapping( path = "/deleteMovie")
	@ResponseBody
	public ResponseEntity<String> deleteMovie(@RequestBody Long id) throws Exception {
		
		moviesService.delete(id);
		String message = "Movie delete sucessfully!! " ;
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@ApiOperation(value = "Get One Movie")
	@GetMapping( path = "/getMovie")
	@ResponseBody
	public ResponseEntity<Optional<MovieEntity>> getMovie(@RequestBody Long id) throws Exception {
		
		Optional<MovieEntity> movie = moviesService.get(id);
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}
	
	@ApiOperation(value = "Get All Movie")
	@GetMapping( path = "/getAllMovies")
	@ResponseBody
	public ResponseEntity<List<MovieEntity>> getAllMovies() throws Exception {
		
		List<MovieEntity> movie = moviesService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(movie);
	}

}
