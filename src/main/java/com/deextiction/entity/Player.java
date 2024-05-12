package src.main.java.com.deextiction.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerId;
	
	@Column
	private boolean isPurchased;
	
	@Column
	private int score;

	public Player() {
		super();
		
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public boolean isPurchased() {
		return isPurchased;
	}

	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", isPurchased=" + isPurchased + ", score=" + score + "]";
	}

	
	
}
