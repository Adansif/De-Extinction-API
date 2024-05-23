package com.deextinction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Specifies that this class is an entity and is mapped to a database table named "players"
@Entity
@Table(name = "players")
public class Player {

	// Specifies the primary key of an entity
	@Id
	// Provides for the specification of generation strategies for the primary keys
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id") // Specifies the mapped column for the primary key
	private int playerId;
	
	// Specifies a single-valued association to another entity (User)
	@OneToOne
	// Specifies the mapped column for the entity association
	@JoinColumn(name = "user_id")
	private User user;
	
	// Specifies a column for storing whether the player has purchased something
	@Column
	private boolean isPurchased;
	
	// Specifies a column for storing the player's score
	@Column
	private int score;

	// Default constructor
	public Player() {
		super();
	}

	// Getter method for playerId
	public int getPlayerId() {
		return playerId;
	}

	// Setter method for playerId
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	// Getter method for user
	public User getUser() {
		return user;
	}

	// Setter method for user
	public void setUser(User user) {
		this.user = user;
	}

	// Getter method for isPurchased
	public boolean isPurchased() {
		return isPurchased;
	}

	// Setter method for isPurchased
	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	// Getter method for score
	public int getScore() {
		return score;
	}

	// Setter method for score
	public void setScore(int score) {
		this.score = score;
	}

	// Overrides the toString method to provide a string representation of the Player object
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", user=" + user + ", isPurchased=" + isPurchased + ", score=" + score + "]";
	}
}
