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

import com.deextinction.entity.Admin;
import com.deextinction.entity.User;
import com.deextinction.exception.ResourceNotFoundException;
import com.deextinction.repository.AdminRepository;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	// Autowiring the repositories for accessing User and Admin data
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	// Endpoint to get all users
	@GetMapping("/users")
	public List<Map<String, Object>> getAllUsers() {
	    // Fetch all users from the repository
	    List<User> users = userRepository.findAll();
	    // Create a list to hold the response data
	    List<Map<String, Object>> response = new ArrayList<>();
	    
	    // Iterate through the list of users
	    for (User user : users) {
	        // Create a map to hold individual user data
	        Map<String, Object> userMap = new HashMap<>();
	        userMap.put("userId", user.getUserId()); // Add user ID
	        userMap.put("name", user.getName()); // Add user name
	        userMap.put("email", user.getEmail()); // Add user email
	        userMap.put("admin", user.getAdmin() != null); // Check if user is an admin

	        // Add the user data map to the response list
	        response.add(userMap);
	    }
	    
	    // Return the response list
	    return response;
	}
	
	// Endpoint to create a new user
	@PostMapping("/users")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, Object> userRequest) {
        // Create a map to hold the response data
        Map<String, Object> response = new HashMap<>();
        try {
            // Create a new user instance and set its properties
            User user = new User();
            user.setName((String) userRequest.get("name"));
            user.setEmail((String) userRequest.get("email"));
            user.setPassword((String) userRequest.get("password"));

            // Save the new user to the repository
            User savedUser = userRepository.save(user);
            response.put("userId", savedUser.getUserId()); // Add user ID to response
            response.put("name", savedUser.getName()); // Add user name to response
            response.put("email", savedUser.getEmail()); // Add user email to response

            // Check if the new user should be an admin
            if (userRequest.containsKey("admin") && (boolean) userRequest.get("admin")) {
                // Create a new admin instance and associate it with the new user
                Admin admin = new Admin();
                admin.setUser(savedUser);
                adminRepository.save(admin);
                response.put("admin", true); // Add admin status to response
            } else {
                response.put("admin", false); // Add non-admin status to response
            }

            // Return the response entity with the new user data
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            e.printStackTrace();
            response.put("error", "Error creating user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
	
	// Endpoint to get a user by their name
	@GetMapping("/users/{userName}")
	public User getUser(@PathVariable String userName){
		// Find the user by their name and return the user object
		return userRepository.findByName(userName);
	}
	
	// Endpoint for user login to validate credentials and check admin status
	@PostMapping("/users/login")
	public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest){
	    // Create a map to hold the response data
	    Map<String, Object> response = new HashMap<>();
	    // Find the user by their name
	    User user = userRepository.findByName(userRequest.getName());

	    // Check if the user exists
	    if (user != null) {
	        // Validate the user's password
	        boolean isPasswordValid = user.getPassword().equals(userRequest.getPassword());
	        // Check if the user is an admin
	        boolean isAdmin = user.getAdmin() != null;

	        // Populate the response map with user details
	        response.put("name", user.getName()); // Add user name
	        response.put("password", isPasswordValid); // Add password validation result
	        response.put("email", user.getEmail()); // Add user email
	        response.put("admin", isAdmin); // Add admin status

	        // Return the response entity with the user details
	        return ResponseEntity.ok(response);
	    } else {
	        // Return a 404 Not Found response if the user does not exist
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
	// Endpoint to update a user's details
	@PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
         @RequestBody User userRequest) throws ResourceNotFoundException {
        // Find the user by their ID, or throw an exception if not found
        User user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        // Update the user's details
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        // Save the updated user to the repository
        final User updatedUser = userRepository.save(user);
        // Return the response entity with the updated user data
        return ResponseEntity.ok(updatedUser);
    }

    // Endpoint to delete a user by their ID
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId)
         throws ResourceNotFoundException {
        // Find the user by their ID, or throw an exception if not found
        User user = userRepository.findById(userId)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        // Delete the user from the repository
        userRepository.delete(user);
        // Create a map to hold the response data
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE); // Add deletion status to response
        // Return the response entity with the deletion status
        return response;
    }
}
