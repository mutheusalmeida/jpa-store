package com.store.jpa.dao;

import com.store.jpa.model.Product;

import jakarta.persistence.EntityManager;

public class ProductDAO {
	private EntityManager entityManager;

	public ProductDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add (Product product) {
		entityManager.persist(product);
	}
	
	public Product manage (Product product) {
		return this.entityManager.merge(product);
	}

	public void delete(Product product) {
		this.entityManager.remove(this.manage(product));
	}

	public void update(Product product) {
		this.manage(product);
	}
}
