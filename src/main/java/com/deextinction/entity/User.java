package com.deextinction.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Specifies that this class is an entity and is mapped to a database table named "users"
@Entity
@Table(name = "users")
public class User {

	// Specifies the primary key of an entity
	@Id
	// Provides for the specification of generation strategies for the primary keys
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id") // Specifies the mapped column for the primary key
	private int userId;
	
	// Specifies a single-valued association to another entity (Player)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore // Indicates that the player field should be ignored by Jackson during serialization
	private Player player;
	
	// Specifies a single-valued association to another entity (Admin)
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore // Indicates that the admin field should be ignored by Jackson during serialization
	private Admin admin;
	
	// Specifies a column for storing the user's name
	@Column
	private String name;
	
	// Specifies a column for storing the user's password
	@Column
	private String password;
	
	// Specifies a column for storing the user's email
	@Column
	private String email;
		
	// Default constructor
	public User() {
		
	}

	// Constructor to initialize User with name, password, and email
	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}

	// Getter method for userId
	public int getUserId() {
		return userId;
	}

	// Setter method for userId
	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Getter method for player
	public Player getPlayer() {
		return player;
	}

	// Setter method for player
	public void setPlayer(Player player) {
		this.player = player;
	}

	// Getter method for admin
	public Admin getAdmin() {
		return admin;
	}

	// Setter method for admin
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// Getter method for name
	public String getName() {
		return name;
	}

	// Setter method for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter method for password
	public String getPassword() {
		return password;
	}

	// Setter method for password
	public void setPassword(String password) {
		this.password = password;
	}

	// Getter method for email
	public String getEmail() {
		return email;
	}

	// Setter method for email
	public void setEmail(String email) {
		this.email = email;
	}

	// Overrides the toString method to provide a string representation of the User object
	@Override
	public String toString() {
		return "User [userId=" + userId + ", player=" + player + ", admin=" + admin + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
}
