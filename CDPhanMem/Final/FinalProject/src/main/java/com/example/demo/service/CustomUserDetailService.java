package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomUserDetail;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findUserByEmail(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		return user.map(CustomUserDetail::new).get();
	}
	
	public Optional<User> findUserByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}

}
