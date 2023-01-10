package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * From users where email = ?1" , nativeQuery = true)
	Optional<User> findUserByEmail(String email);
	
	@Query(value = "SELECT * From users where email = ?1", nativeQuery = true)
	User findUser(String email);
}
