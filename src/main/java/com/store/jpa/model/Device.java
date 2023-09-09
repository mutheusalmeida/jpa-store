package com.store.jpa.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "devices")
public class Device extends Product {
	
	private String model;
	private String brand;

	public Device() {
		
	}

	public Device(String name, String description, BigDecimal price, Category category, String model, String brand) {
		super(name, description, price, category);
		this.model = model;
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
