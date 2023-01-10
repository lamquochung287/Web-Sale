package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.LaptopDTO;
import com.example.demo.entity.Laptop;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.LaptopService;

@Controller
public class HomeController {
	@Autowired
	CategoriesService categoriesService;
	@Autowired
	LaptopService laptopService;
	
	@GetMapping({"/","/home"})
	public String viewHomePage(Model model) {
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		model.addAttribute("laptops", laptopService.getAllLaptop());
		return "index";
	}

	@GetMapping("/shop")
	public String viewShopPage(Model model) {
		model.addAttribute("categories", categoriesService.getAllCategories());
		model.addAttribute("laptops", laptopService.getAllLaptop());
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		return "shop";
	}
	
	@GetMapping("/search")
	public String viewShopPageSearch(Model model, @Param("keyword") String keyword) {
		List<Laptop> listFind = laptopService.searchLaptop(keyword); 
		model.addAttribute("categories", categoriesService.getAllCategories());
		model.addAttribute("laptops", listFind);
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		return "shop";
	}
	
	@GetMapping("/choosePrice")
	public String viewShopPagePrice(Model model, @Param("choosePrice") int choosePrice) {
		List<Laptop> listResult = laptopService.findByPrice(choosePrice);
		model.addAttribute("categories", categoriesService.getAllCategories());
		model.addAttribute("laptops", listResult);
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String viewShopPageByCategory(Model model, @PathVariable int id) {
		model.addAttribute("categories", categoriesService.getAllCategories());
		model.addAttribute("laptops", laptopService.getLaptopByCategory(id));
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		return "shop";
	}
	
	@GetMapping("/shop/viewlaptop/{id}")
	public String viewDetailLaptop(Model model, @PathVariable int id) {
		model.addAttribute("laptop",laptopService.getLaptopById(id));
		model.addAttribute("cartCount",LaptopDTO.cart.size());
		return "viewLaptop";
	}
	
	
}
