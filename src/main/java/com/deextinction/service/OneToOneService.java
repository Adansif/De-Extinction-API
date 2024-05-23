package com.deextinction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deextinction.entity.Admin;
import com.deextinction.entity.Player;
import com.deextinction.entity.User;
import com.deextinction.repository.AdminRepository;
import com.deextinction.repository.PlayerRepository;
import com.deextinction.repository.UserRepository;

// Annotation to indicate that this class is a Spring service component
@Service
public class OneToOneService {

	// Autowiring the repositories for accessing User, Player, and Admin data
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	// Method to save a User entity to the database
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	// Method to save a Player entity to the database
	public void savePlayer(Player player) {
		playerRepository.save(player);
	}
	
	// Method to save an Admin entity to the database
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
}
