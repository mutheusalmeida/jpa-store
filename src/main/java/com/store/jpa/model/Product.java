package com.store.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "products")
@Inheritance (strategy = InheritanceType.JOINED)
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private LocalDate date = LocalDate.now();
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Category category;
	
	public Product() {
		
	}
	
	public Product(String name, String description, BigDecimal price, Category category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public Category getCategory_id() {
		return category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
