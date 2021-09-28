package com.movies.api.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
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
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("select u from UserEntity u where u.id= :id")
	UserEntity findById(@Param("id") long id);
	
	@Query("select u from UserEntity u where u.email = :email")
	UserEntity findByEmail(@Param("email") String email);
	
	@Query("select u from UserEntity u ")
	List<UserEntity> findAll();
	
	
}
