package com.movies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movies.api.repository.MoviesRepository;

/**
 * 
 * @author jurandir
 *
 */

@Controller
public class StatsController {
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getStats() throws Exception {
		
		return ResponseEntity.status(HttpStatus.OK).body(moviesRepository.ByGenre());
		
		
	}

}
