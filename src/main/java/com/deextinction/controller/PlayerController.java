package com.deextinction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.Player;
import com.deextinction.entity.User;
import com.deextinction.exception.ResourceNotFoundException;
import com.deextinction.repository.PlayerRepository;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PlayerController {
	// Autowiring repositories for player and user entities
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	UserRepository userRepository;
	// Endpoint to get all users' scores, sorted in descending order
	@GetMapping("/players/scores")
    public ResponseEntity<List<Map<String, Object>>> getAllUsersScore() {
        // Fetch all players ordered by their scores in descending order
        List<Player> players = playerRepository.findByOrderByScoreDesc();
        // Transform the list of players to a list of maps containing player names and scores
        List<Map<String, Object>> response = players.stream()
                .map(player -> {
                    Map<String, Object> playerData = new HashMap<>();
                    playerData.put("name", player.getUser().getName());// Add player's name
                    playerData.put("score", player.getScore()); // Add player's score
                    return playerData;
                })
                .collect(Collectors.toList());
        // Return the response entity with the list of player data maps
        return ResponseEntity.ok(response);
    }
	// Endpoint to get top 3 users' scores, sorted in descending order
	@GetMapping("/players/topscores")
    public ResponseEntity<List<Map<String, Object>>> getTop3UsersScore() {
        // Fetch the top 3 players ordered by their scores in descending order
        List<Player> players = playerRepository.findTop3ByOrderByScoreDesc();
        // Transform the list of top players to a list of maps containing player names and scores
        List<Map<String, Object>> response = players.stream()
                .map(player -> {
                    Map<String, Object> playerData = new HashMap<>();
                    playerData.put("name", player.getUser().getName()); // Add player's name
                    playerData.put("score", player.getScore()); // Add player's score
                    return playerData;
                })
                .collect(Collectors.toList());
     // Return the response entity with the list of top player data maps
        return ResponseEntity.ok(response);
    }
	// Endpoint for user login to validate credentials and check player status
	@PostMapping("/players/login")
	public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest){
	    // Initialize a map to hold the response data
	    Map<String, Object> response = new HashMap<>();
	    // Find the user by their name
	    User user = userRepository.findByName(userRequest.getName());
	    // Check if the user exists
	    if (user != null) {
	        // Validate the user's password
	        boolean isPasswordValid = user.getPassword().equals(userRequest.getPassword());
	        // Check if the user is associated with a player
	        boolean isPlayer = user.getPlayer() != null;
	        // Populate the response map with user details
	        response.put("name", user.getName()); // Add user's name
	        response.put("password", isPasswordValid); // Add password validation result
	        response.put("player", isPlayer); // Add player status
	        // Return the response entity with the response data
	        return ResponseEntity.ok(response);
	    } else {
	        // Return a 404 Not Found response if the user does not exist
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	// Endpoint to update the score of a specific player
	@PutMapping("/players/{name}/{score}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "name") String name,
    		@PathVariable(value = "score") int score){
        // Find the user by their name
        User user = userRepository.findByName(name);
        // Retrieve the player associated with the user
        Player player = user.getPlayer();
        // Update the player's score
        player.setScore(score);
        // Associate the updated player with the user
        user.setPlayer(player);
        // Save the updated user in the repository
        final User updatedUser = userRepository.save(user);
        // Return the response entity indicating success
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
	
}
