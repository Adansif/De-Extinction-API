package com.deextinction.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.User;
import com.deextinction.exception.ResourceNotFoundException;
import com.deextinction.repository.AdminRepository;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/users")
	public List<Map<String, Object>> getAllUsers() {
	    List<User> users = userRepository.findAll();
	    List<Map<String, Object>> response = new ArrayList<>();
	    
	    for (User user : users) {
	        Map<String, Object> userMap = new HashMap<>();
	        userMap.put("userId", user.getUserId());
	        userMap.put("name", user.getName());
	        userMap.put("email", user.getEmail());
	        userMap.put("admin", user.getAdmin() != null); 

	        response.add(userMap);
	    }
	    
	    return response;
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
	
	@PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
         @RequestBody User userRequest) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId)
         throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
