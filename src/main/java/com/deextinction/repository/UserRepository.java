package com.deextinction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findTop3ByOrderByScoreDesc();
	
}
