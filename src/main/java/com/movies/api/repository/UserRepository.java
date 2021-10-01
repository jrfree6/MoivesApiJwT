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
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("select u from UserEntity u where u.id= :id")
	UserEntity findById(@Param("id") long id);
	
	@Query("select u from UserEntity u where u.email = :email")
	UserEntity findByEmail(@Param("email") String email);

	@Query("select u from UserEntity u where u.username = :username")
	UserEntity findByUserName(@Param("username") String userName);

	@Query("select u from UserEntity u ")
	List<UserEntity> findAll();
	
	
}
