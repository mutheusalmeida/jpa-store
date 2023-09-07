package com.store.jpa.dao;

import java.util.List;

import com.store.jpa.model.Product;

import jakarta.persistence.EntityManager;

public class ProductDAO {
	private EntityManager entityManager;

	public ProductDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private Product manage(Product product) {
		return this.entityManager.merge(product);
	}
	
	public void add(Product product) {
		this.entityManager.persist(product);
	}

	public void delete(Product product) {
		this.entityManager.remove(this.manage(product));
	}

	public void update(Product product) {
		this.manage(product);
	}
	
	public Product getProduct(Long id) {
		return this.entityManager.find(Product.class, id);
	}
	
	public List<Product> getProducts() {
		String jpql = "SELECT p FROM Product p";
		
		return this.entityManager.createQuery(jpql, Product.class).getResultList();
	}
}
