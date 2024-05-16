package com.deextinction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deextinction.entity.Admin;
import com.deextinction.entity.Player;
import com.deextinction.entity.User;
import com.deextinction.repository.AdminRepository;
import com.deextinction.repository.PlayerRepository;
import com.deextinction.repository.UserRepository;

@Service
public class OneToOneService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void savePlayer(Player player) {
		playerRepository.save(player);
	}
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
}
