package com.deextinction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class PlayerController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@GetMapping("/users/scores")
	public List<Player> getAllUsersScore() {
		return playerRepository.findTop3ByOrderByScoreDesc();		
	}
	
}
