package com.deextinction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deextinction.controller.UserController;
import com.deextinction.entity.Admin;
import com.deextinction.entity.Player;
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
		User user2 = new User("Gabri", "3456", "gabri@gmail.com");
		
		oneToOneService.saveUser(user1);
		oneToOneService.saveUser(user2);
		
		Player player1 = new Player();
		
		player1.setUser(user1);
		player1.setScore(300);
		player1.setPurchased(true);
		
		oneToOneService.savePlayer(player1);
		
		Admin admin1 = new Admin();
		
		admin1.setUser(user2);
		
		oneToOneService.saveAdmin(admin1);
	}
}
