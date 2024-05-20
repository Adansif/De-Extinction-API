package com.deextinction.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
	List<Player> findTop3ByOrderByScoreDesc();
    
	List<Player> findByOrderByScoreDesc();
}
