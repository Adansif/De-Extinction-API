package com.deextinction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    /**
     * Finds an Admin by the associated User's name.
     * 
     * @param name the name of the User associated with the Admin.
     * @return the Admin associated with the given User's name.
     */
    Admin findByUserName(String name);
}
