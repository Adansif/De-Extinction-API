package com.deextinction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    /**
     * Finds the top 3 players ordered by their score in descending order.
     * 
     * @return a list of the top 3 players with the highest scores.
     */
    List<Player> findTop3ByOrderByScoreDesc();

    /**
     * Finds all players ordered by their score in descending order.
     * 
     * @return a list of all players ordered by their scores in descending order.
     */
    List<Player> findByOrderByScoreDesc();
}