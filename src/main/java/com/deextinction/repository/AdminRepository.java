package com.deextinction.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deextinction.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByUserName(String name);
}
