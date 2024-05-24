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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdminRepository adminRepository;

    /**
     * Get all users.
     * 
     * @return List of maps containing user details.
     */
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

    /**
     * Create a new user.
     * 
     * @param userRequest Map containing user details.
     * @return ResponseEntity containing the created user details.
     */
    @PostMapping("/users")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, Object> userRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = new User();
            user.setName((String) userRequest.get("name"));
            user.setEmail((String) userRequest.get("email"));
            user.setPassword((String) userRequest.get("password"));
            User savedUser = userRepository.save(user);
            response.put("userId", savedUser.getUserId());
            response.put("name", savedUser.getName());
            response.put("email", savedUser.getEmail());
            if (userRequest.containsKey("admin") && (boolean) userRequest.get("admin")) {
                Admin admin = new Admin();
                admin.setUser(savedUser);
                adminRepository.save(admin);
                response.put("admin", true);
            } else {
                response.put("admin", false);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", "Error creating user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Get a user by their name.
     * 
     * @param userName The name of the user.
     * @return The User object.
     */
    @GetMapping("/users/{userName}")
    public User getUser(@PathVariable String userName) {
        return userRepository.findByName(userName);
    }

    /**
     * User login to validate credentials and check admin status.
     * 
     * @param userRequest User object containing login credentials.
     * @return ResponseEntity containing user details if login is successful, or 404 if user does not exist.
     */
    @PostMapping("/users/login")
    public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest) {
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

    /**
     * Update a user's details.
     * 
     * @param userId The ID of the user.
     * @param userRequest User object containing updated details.
     * @return ResponseEntity containing the updated user.
     * @throws ResourceNotFoundException if the user is not found.
     */
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

    /**
     * Delete a user by their ID.
     * 
     * @param userId The ID of the user.
     * @return Map containing the deletion status.
     * @throws ResourceNotFoundException if the user is not found.
     */
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}