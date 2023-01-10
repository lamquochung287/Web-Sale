package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	
	public List<Order> getAllOrder(){
		return orderRepo.findAll();
	}
	
	public Optional<Order> getOrderById(int id){
		return orderRepo.findById(id);
	}
	
	public void addOrder(Order order) {
		orderRepo.save(order);
	}
	
	public void deleteOrder(int id) {
		orderRepo.deleteById(id);
	}
}
