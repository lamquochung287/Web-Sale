package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import com.example.demo.entity.Laptop;

// this class use for user save the laptop that added to cart 
public class LaptopDTO {
	
	public static List<Laptop> cart;
	public static String userName;
	static {
		cart = new ArrayList<Laptop>();
	}
}
