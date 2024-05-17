package com.deextinction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.Player;
import com.deextinction.repository.PlayerRepository;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@GetMapping("/players/scores")
	public List<Player> getAllUsersScore() {
		return playerRepository.findTop3ByOrderByScoreDesc();		
	}
	
}
