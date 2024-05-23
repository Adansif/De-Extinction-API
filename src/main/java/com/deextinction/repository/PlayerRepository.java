package com.deextinction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Player;

// Annotation to indicate that this interface is a Spring Data repository
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	// Custom query method to find the top 3 players ordered by their score in descending order
	List<Player> findTop3ByOrderByScoreDesc();
    
	// Custom query method to find all players ordered by their score in descending order
	List<Player> findByOrderByScoreDesc();
}
