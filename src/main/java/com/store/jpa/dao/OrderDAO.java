package com.store.jpa.dao;

import java.math.BigDecimal;

import com.store.jpa.model.Order;

import jakarta.persistence.EntityManager;

public class OrderDAO {
	private EntityManager entityManager;

	public OrderDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Order order) {
		this.entityManager.persist(order);
	}

	public BigDecimal getTotalValue() {
		String jpql = "SELECT SUM(o.totalValue) FROM Order o";
		
		return this.entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
}
