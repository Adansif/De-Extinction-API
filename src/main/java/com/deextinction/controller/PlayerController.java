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

    /**
     * Get all users' scores, sorted in descending order.
     * 
     * @return ResponseEntity containing a list of maps with user names and scores.
     */
    @GetMapping("/players/scores")
    public ResponseEntity<List<Map<String, Object>>> getAllUsersScore() {
        List<Player> players = playerRepository.findByOrderByScoreDesc();
        List<Map<String, Object>> response = players.stream()
                .map(player -> {
                    Map<String, Object> playerData = new HashMap<>();
                    playerData.put("name", player.getUser().getName());
                    playerData.put("score", player.getScore());
                    return playerData;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    /**
     * Get top 3 users' scores, sorted in descending order.
     * 
     * @return ResponseEntity containing a list of maps with the top 3 user names and scores.
     */
    @GetMapping("/players/topscores")
    public ResponseEntity<List<Map<String, Object>>> getTop3UsersScore() {
        List<Player> players = playerRepository.findTop3ByOrderByScoreDesc();
        List<Map<String, Object>> response = players.stream()
                .map(player -> {
                    Map<String, Object> playerData = new HashMap<>();
                    playerData.put("name", player.getUser().getName());
                    playerData.put("score", player.getScore());
                    return playerData;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    /**
     * User login to validate credentials and check player status.
     * 
     * @param userRequest User object containing login credentials.
     * @return ResponseEntity containing a map with user details if login is successful,
     *         or a 404 Not Found status if the user does not exist.
     */
    @PostMapping("/players/login")
    public ResponseEntity<Map<String, Object>> getUserDetails(@RequestBody User userRequest) {
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

    /**
     * Update user's score.
     * 
     * @param name Name of the user.
     * @param score New score to update.
     * @return ResponseEntity with status OK if the score is updated,
     *         NO_CONTENT if the new score is not higher than the current score,
     *         or NOT_FOUND if the user does not exist.
     */
    @PutMapping("/players/{name}/{score}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "name") String name,
                                           @PathVariable(value = "score") int score) {
        User user = userRepository.findByName(name);
        if (user != null) {
            Player player = user.getPlayer();
            if (player.getScore() < score) {
                player.setScore(score);
                user.setPlayer(player);
                final User updatedUser = userRepository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}