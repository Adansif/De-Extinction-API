package com.deextinction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.User;

// Annotation to indicate that this interface is a Spring Data repository
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// Custom query method to find a User by their name using a JPQL query
	@Query("select u from User u where u.name = ?1")
	User findByName(String name);
}
