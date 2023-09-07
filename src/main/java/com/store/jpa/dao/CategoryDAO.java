package com.store.jpa.dao;

import com.store.jpa.model.Category;

import jakarta.persistence.EntityManager;

public class CategoryDAO {
	private EntityManager entityManager;

	public CategoryDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add (Category category) {
		entityManager.persist(category);
	}
}

