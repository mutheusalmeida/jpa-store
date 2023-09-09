package com.store.jpa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "orders")
public class Order {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "total_value")
	private BigDecimal totalValue = BigDecimal.ZERO;
	
	private LocalDate date = LocalDate.now();
	
	@ManyToOne
	private Client client;
	
	@OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public Order() {
		
	}

	public Order(Client client) {
		this.client = client;
	}
	
	public void addOrderItem (OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
		this.totalValue = this.totalValue.add(orderItem.getValue());
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public LocalDate getDate() {
		return date;
	}
}

