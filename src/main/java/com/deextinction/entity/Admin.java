package com.deextinction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Admin() {
        super();
    }

    /**
     * Gets the admin ID.
     * 
     * @return the admin ID.
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * Sets the admin ID.
     * 
     * @param adminId the admin ID to set.
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
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
     * Provides a string representation of the Admin object.
     * 
     * @return a string representation of the Admin object.
     */
    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", user=" + user + "]";
    }
}
