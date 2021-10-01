package com.movies.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.api.entity.MovieEntity;
import com.movies.api.repository.MoviesRepository;
/**
 * 
 * @author jurandir
 *
 */

@Service
public class MoviesService {
	
	@Autowired
	private MoviesRepository moviesRepository;
	
	public MovieEntity create(MovieEntity movie) {
		return moviesRepository.save(movie);
	}
	public void delete(Long id) {
		moviesRepository.deleteById(id);
	}
	
	public Optional<MovieEntity> get(Long id) {
		return moviesRepository.findById(id);
	}
	
	public MovieEntity getByTitle(String title) {
		return moviesRepository.findByTitle(title);
	}

	public List<MovieEntity> getAll() {
		return moviesRepository.findAll();
	}
	public List<Object> getTotalByGenre() {
		return moviesRepository.ByGenre();
	}
	public Integer getTotalAvailable() {
		return moviesRepository.getAvailable();
	}
	
	
}
