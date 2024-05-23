package com.deextinction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean isPurchased;

    @Column
    private int score;

    public Player() {
        super();
    }

    /**
     * Gets the player ID.
     * 
     * @return the player ID.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets the player ID.
     * 
     * @param playerId the player ID to set.
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Gets the associated User.
     * 
     * @return the associated User.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the associated User.
     * 
     * @param user the User to associate.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Checks if the player has purchased something.
     * 
     * @return true if the player has purchased, false otherwise.
     */
    public boolean isPurchased() {
        return isPurchased;
    }

    /**
     * Sets the purchased status of the player.
     * 
     * @param isPurchased the purchased status to set.
     */
    public void setPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    /**
     * Gets the player's score.
     * 
     * @return the player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score.
     * 
     * @param score the score to set.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Provides a string representation of the Player object.
     * 
     * @return a string representation of the Player object.
     */
    @Override
    public String toString() {
        return "Player [playerId=" + playerId + ", user=" + user + ", isPurchased=" + isPurchased + ", score=" + score + "]";
    }
}
