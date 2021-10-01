package com.movies.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movies.api.entity.MovieEntity;
/**
 * 
 * @author jurandir
 *
 */

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity, Long> {
	
	@Query("select u from MovieEntity u where u.id= :id")
	MovieEntity findById(@Param("id") long id);
	
	@Query("select u from MovieEntity u where u.title= :title")
	MovieEntity findByTitle(@Param("title") String title);
	
	@Query("select count(*) as total from MovieEntity ")
	Integer  getAvailable();
	
	//genre
	@Query("select m.genre, count(*) as quantity  from MovieEntity m group by m.genre ")
	List<Object>  ByGenre();

	@Query("select m from MovieEntity m ")
	List<MovieEntity> findAll();
	
}
