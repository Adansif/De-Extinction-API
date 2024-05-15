package com.deextinction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deextinction.entity.User;
import com.deextinction.repository.UserRepository;

@Service
public class OneToOneService {

	@Autowired
	UserRepository userRepository;
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
}
