package com.deextinction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// Specifies that this class is an entity and is mapped to a database table
@Entity
@Table(name = "admins")
public class Admin {

	// Specifies the primary key of an entity
	@Id
	// Provides for the specification of generation strategies for the primary keys
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	// Specifies a single-valued association to another entity
	@OneToOne
	// Specifies the mapped column for the entity association
	@JoinColumn(name = "user_id")
	private User user;

	// Default constructor
	public Admin() {
		super();
	}

	// Getter method for adminId
	public int getAdminId() {
		return adminId;
	}

	// Setter method for adminId
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	// Getter method for user
	public User getUser() {
		return user;
	}

	// Setter method for user
	public void setUser(User user) {
		this.user = user;
	}

	// Overrides the toString method to provide a string representation of the Admin object
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", user=" + user + "]";
	}
}
