package com.deextinction.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.Player;
import com.deextinction.entity.User;
import com.deextinction.repository.PlayerRepository;
import com.deextinction.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*", allowedHeaders="*")
public class PlayerController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/players/scores")
	public List<Player> getAllUsersScore() {
		return playerRepository.findTop3ByOrderByScoreDesc();		
	}
	
	@PostMapping("/players/login")
	public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest){
	    Map<String, Object> response = new HashMap<>();
	    User user = userRepository.findByName(userRequest.getName());

	    if (user != null) {
	        boolean isPasswordValid = user.getPassword().equals(userRequest.getPassword());
	        boolean isPlayer = user.getPlayer() != null;

	        response.put("name", user.getName());
	        response.put("password", isPasswordValid);
	        response.put("player", isPlayer);

	        return ResponseEntity.ok(response);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
}
