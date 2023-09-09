package com.store.jpa.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "order_items")
public class OrderItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "unit_price")
	private BigDecimal unitPrice;
	
	private int quantity;

	@ManyToOne (fetch = FetchType.LAZY)
	private Product product;
	
	@ManyToOne (fetch = FetchType.LAZY)
	private Order order;
	
	public OrderItem() {
		
	}
	
	public OrderItem(int quantity, Product product, Order order) {
		this.unitPrice = product.getPrice();
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getValue() {
		return this.unitPrice.multiply(new BigDecimal(this.quantity));
	}
}

