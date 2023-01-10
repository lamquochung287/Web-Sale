package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	
	public User findUser(String email) {
		return userRepo.findUser(email);
	}
}
