package com.deextinction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deextinction.controller.UserController;
import com.deextinction.entity.User;
import com.deextinction.repository.UserRepository;
import com.deextinction.service.OneToOneService;



@SpringBootApplication
public class InitDatabase implements CommandLineRunner{
	
	@Autowired
	OneToOneService oneToOneService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserController userController;
	
	public static void main(String[] args) {
		SpringApplication.run(InitDatabase.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user1 = new User("Adan", "1234", "adan@gmail.com");
		
		oneToOneService.saveUser(user1);
	}
}
