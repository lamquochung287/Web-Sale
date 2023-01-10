package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LaptopDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepo;
import com.example.demo.repository.UserRepo;

@Controller
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	
	@GetMapping("/login")
	public String viewLoginPage() {
		LaptopDTO.cart.clear();
		return "login";
	}
	
	
	@GetMapping("/register")
	public String viewRegisterPage(Model model) {
		model.addAttribute("users",new User());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String saveRegister(Model model, User user,HttpServletRequest request) throws ServletException
	{
		String pass = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(pass));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepo.findById(2).get());
		user.setRoles(roles);
		userRepo.save(user);
		request.login(user.getEmail(), pass);
		return "redirect:/";
	}
	
}
