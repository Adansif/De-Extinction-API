package com.deextinction.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
	
}
