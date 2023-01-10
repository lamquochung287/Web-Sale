package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	@NotNull
	@Column(name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="laptop_id")
	private Laptop laptop;

	public Order(int id, @NotNull double price, User user, Laptop laptop) {
		super();
		this.id = id;
		this.price = price;
		this.user = user;
		this.laptop = laptop;
	}
	
	public Order(@NotNull double price, User user, Laptop laptop) {
		super();
		this.price = price;
		this.user = user;
		this.laptop = laptop;
	}

	public Order() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	
	
}
