package com.deextinction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Admin;

// Annotation to indicate that this interface is a Spring Data repository
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	// Custom query method to find an Admin by the associated User's name
	Admin findByUserName(String name);
}
