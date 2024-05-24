package com.deextinction;
import java.util.ArrayList;
import java.util.Random;

//Importing necessary Spring Boot and project-specific classes
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
    // Autowiring the services and repositories needed
	@Autowired
	OneToOneService oneToOneService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserController userController;
    // Main method to run the Spring Boot application
	public static void main(String[] args) {
		SpringApplication.run(InitDatabase.class, args);
	}
    // Method that runs after the application context is loaded and starts
	@Override
	public void run(String... args) throws Exception{
		
		String[] usernamesArray = {
	            "ShadowHunter", "ViperStrike", "DragonSlayer", "NightStalker", "ThunderFury",
	            "PhantomAssassin", "WarlockWizard", "CyberNinja", "FrostBite", "GhostRider", 
	            "InfernoBlaze", "DarkAvenger", "TitanCrusher", "BladeMaster", "SteelShadow",
	            "MysticSorcerer", "VenomViper", "RavenClaw", "BlitzKrieg", "SavageWolf" };
		
		String[] emails = {
	            "ShadowHunter@gmail.com", "ViperStrike@gmail.com", "DragonSlayer@gmail.com", "NightStalker@gmail.com", "ThunderFury@gmail.com",
	            "PhantomAssassin@gmail.com", "WarlockWizard@gmail.com", "CyberNinja@gmail.com", "FrostBite@gmail.com", "GhostRider@gmail.com",
	            "InfernoBlaze@gmail.com", "DarkAvenger@gmail.com", "TitanCrusher@gmail.com", "BladeMaster@gmail.com", "SteelShadow@gmail.com",
	            "MysticSorcerer@gmail.com", "VenomViper@gmail.com", "RavenClaw@gmail.com", "BlitzKrieg@gmail.com", "SavageWolf@gmail.com"};
		
		String[] passwords = {
	            "B@ttleF!eld9", "M@trixR3l0ad", "L0ck&K3y!", "C@stl3V@ult", "Qw3rtY!123",
	            "S@f3H@v3n", "R3dDr@g0n!", "Blu3Sky$89", "Z3r0H0ur#", "Ult!m@t3Pw",
	            "St@rG@z3r7", "D!m3ns!0nX", "R3v3l@t!0n$", "S3cur3N3tw0rk", "L!ghtH0us3*",
	            "M0unt@!nP@ss", "Bl@z!ngF!re", "C0sm!cW@v3", "3l3ctricSh0ck", "Ph0en!xR!s3"};
		
		ArrayList<User> usersArray = new ArrayList<>();
		
		for (int i = 0; i < usernamesArray.length; i++) {
            User user = new User();
            user.setName(usernamesArray[i]);
            user.setEmail(emails[i]);
            user.setPassword(passwords[i]);
            usersArray.add(user);
            oneToOneService.saveUser(user);
        }
		
		User adansif = new User();
		adansif.setName("Adansif");
		adansif.setPassword("1234");
		adansif.setEmail("adansif@gmail.com");
		
		User gabri = new User();
		gabri.setName("Gabri");
		gabri.setPassword("1234");
		gabri.setEmail("gabri@gmail.com");


        // Saving users to the database
		oneToOneService.saveUser(adansif);
		oneToOneService.saveUser(gabri);
		
        for (User user : usersArray) {
			Player player = new Player();
			player.setUser(user);
			player.setScore(new Random().nextInt(0, 101));
			player.setPurchased(true);
			oneToOneService.savePlayer(player);
		}
        
        Player adansifPlayer = new Player();
        adansifPlayer.setUser(adansif);
        adansifPlayer.setScore(10);
        adansifPlayer.setPurchased(true);
        
        Player gabriPlayer = new Player();
        gabriPlayer.setUser(gabri);
        gabriPlayer.setScore(10);
        gabriPlayer.setPurchased(true);
        
        oneToOneService.savePlayer(adansifPlayer);
        oneToOneService.savePlayer(gabriPlayer);
		
        // Creating an admin instance
		Admin adansifAdmin = new Admin();
		Admin gabriAdmin = new Admin();
		
        // Associating the admin with a user
		adansifAdmin.setUser(adansif);
		gabriAdmin.setUser(gabri);
		
        // Saving the admin to the database
		oneToOneService.saveAdmin(adansifAdmin);
		oneToOneService.saveAdmin(gabriAdmin);
	}
}
