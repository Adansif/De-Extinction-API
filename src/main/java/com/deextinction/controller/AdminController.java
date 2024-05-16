package com.deextinction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deextinction.entity.Admin;
import com.deextinction.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	
	@GetMapping("/admin/{userName}")
	public Admin getAdmin(@PathVariable String userName){
		return adminRepository.findByUserName(userName);
	}
	
}
