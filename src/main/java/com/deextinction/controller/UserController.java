package com.deextinction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.User;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();				
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User userRequest) {
		return userRepository.save(userRequest);
				
	}
	
	@GetMapping("/users/score")
	public List<User> getAllUsersScore() {
		return userRepository.findTop3ByOrderByScoreDesc();
				
	}
	
}
