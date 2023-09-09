package com.store.jpa.dao;

import com.store.jpa.model.Category;

import jakarta.persistence.EntityManager;

public class CategoryDAO {
	private EntityManager entityManager;

	public CategoryDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private Category manage(Category category) {
		return this.entityManager.merge(category);
	}

	public void add(Category category) {
		this.entityManager.persist(category);
	}

	public void delete(Category category) {
		this.entityManager.remove(this.manage(category));
	}

	public void update(Category category) {
		this.manage(category);
	}

	public Category getCategoryByName(String name) {
		String jpql = "SELECT c FROM Category c WHERE c.name = :name";

		return this.entityManager.createQuery(jpql, Category.class).setParameter("name", name).getSingleResult();
	}
}
