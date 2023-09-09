package com.store.jpa.vo;

import java.time.LocalDate;

public class SalesReportVo {
	private String name;
	private Long quantity;
	private LocalDate date;
	
	public SalesReportVo(String name, Long quantity, LocalDate date) {
		this.name = name;
		this.quantity = quantity;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return String.format("Product name: %s | Quantity: %d | Last date: %s", this.name, this.quantity, this.date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
