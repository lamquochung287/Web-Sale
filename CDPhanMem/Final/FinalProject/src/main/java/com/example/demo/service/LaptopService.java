package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Laptop;
import com.example.demo.repository.LaptopRepo;

@Service
public class LaptopService {

	@Autowired
	public LaptopRepo laptopRepo;
	
	public List<Laptop> getAllLaptop(){
		return laptopRepo.findAll();
	}
	
	public List<Laptop> getLaptopByCategory(int id){
		return laptopRepo.findAllByCategory(id);
	}
	
	
	public void addLaptop(Laptop laptop) {
		laptopRepo.save(laptop);
	}
	
	public Laptop getLaptopById(int id) {
		return laptopRepo.getById(id);
	}
	
	public void deleteLaptop(Integer id) {
		laptopRepo.deleteById(id);;
	}
	
	public List<Laptop> searchLaptop(String keyword){
		if(keyword != null) {
			return laptopRepo.findAllByName(keyword);
		}
		return laptopRepo.findAll();
	}
	
	public List<Laptop> findByPrice(int choosePrice){
		if(choosePrice > 0) {
			if(choosePrice == 0)
				return laptopRepo.findAll();
			if(choosePrice == 1)
				return laptopRepo.findByPriceHighToLow();
			if(choosePrice == 2)
				return laptopRepo.findByPriceLowToHigh();
			if(choosePrice == 3)
				return laptopRepo.findByPriceLowerThan();
			if(choosePrice == 4)
				return laptopRepo.findByPriceHigherThan();
		}
		return laptopRepo.findAll();
	}
}
