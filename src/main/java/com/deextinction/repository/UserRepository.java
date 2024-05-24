package com.deextinction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Finds a User by their name using a JPQL query.
     * 
     * @param name the name of the User.
     * @return the User with the specified name.
     */
    @Query("select u from User u where u.name = ?1")
    User findByName(String name);
}
