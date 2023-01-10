package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.ToDoubleFunction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.LaptopDTO;
import com.example.demo.entity.CustomUserDetail;

import com.example.demo.entity.Laptop;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;

import com.example.demo.repository.UserRepo;
import com.example.demo.service.CustomUserDetailService;

import com.example.demo.service.LaptopService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

@Controller
public class CartController {
	
	@Autowired
	LaptopService laptopService;
	
	@Autowired
	OrderService orderService;
	
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		LaptopDTO.cart.add(laptopService.getLaptopById(id));
		return "redirect:/shop";
	}
	@GetMapping("/cart")
	public String viewCartPage(Model model) {
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		model.addAttribute("total", LaptopDTO.cart.stream().mapToDouble(Laptop::getPrice).sum()); // add @Data vô mới Laptop::getPrice đc
		model.addAttribute("cart",LaptopDTO.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String removeCart(@PathVariable int index) {
		LaptopDTO.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model, Principal principal) {
		
		Order order = new Order();
		
		User user = userService.findUser(principal.getName());
		order.setUser(user); // get user by name through princial => use userRepo to find id user by the username ( email
		
		for(Laptop i : LaptopDTO.cart) {
			orderService.addOrder(new Order(i.getPrice(),user, i));
		}
		
		LaptopDTO.cart.clear(); // after add all laptop to database with user id clear data
		return "checkout";
	}

	
	
	
}
