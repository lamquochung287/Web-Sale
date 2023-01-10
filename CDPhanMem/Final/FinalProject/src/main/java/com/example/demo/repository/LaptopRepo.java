package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>  {
	
	@Query(value = "SELECT * FROM laptop where idcate =?1", nativeQuery = true)
	public List<Laptop> findAllByCategory(int id);	
	
	@Query(value = "SELECT * FROM laptop where name like %?1%",nativeQuery = true)
	public List<Laptop> findAllByName(String keyword);
	
	@Query(value = "SELECT * FROM laptop where price < 2000", nativeQuery = true)
	public List<Laptop> findByPriceLowerThan();
	
	@Query(value = "SELECT * FROM laptop order by price desc", nativeQuery = true)
	public List<Laptop> findByPriceHighToLow();
	
	@Query(value = "SELECT * FROM laptop order by price", nativeQuery = true)
	public List<Laptop> findByPriceLowToHigh();
	
	@Query(value = "SELECT * FROM laptop where price >= 2000", nativeQuery = true)
	public List<Laptop> findByPriceHigherThan();
}
