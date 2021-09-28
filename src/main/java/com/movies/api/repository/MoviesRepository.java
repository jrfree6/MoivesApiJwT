package com.movies.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movies.api.entity.UserEntity;
/**
 * 
 * @author jurandir
 *
 */

@Repository
public interface MoviesRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("select u from MovieEntity u where u.id= :id")
	UserEntity findById(@Param("id") long id);
	
	@Query("select count(*) from MovieEntity ")
	Integer  Availabel();
	
	//genre
	@Query("select m.genre, count(*) as quantity  from MovieEntity m group by m.genre ")
	List<Object>  ByGenre();

	
	
}
