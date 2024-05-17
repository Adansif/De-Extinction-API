package com.deextinction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.User;
import com.deextinction.repository.AdminRepository;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();				
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User userRequest) {
		return userRepository.save(userRequest);
				
	}
	
	@GetMapping("/users/{userName}")
	public User getUser(@PathVariable String userName){
		return userRepository.findByName(userName);
	}
	
	@PostMapping("/users/login")
	public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest){
	    Map<String, Object> response = new HashMap<>();
	    User user = userRepository.findByName(userRequest.getName());

	    if (user != null) {
	        boolean isPasswordValid = user.getPassword().equals(userRequest.getPassword());
	        boolean isAdmin = user.getAdmin() != null;

	        response.put("name", user.getName());
	        response.put("password", isPasswordValid);
	        response.put("email", user.getEmail());
	        response.put("admin", isAdmin);

	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
}
