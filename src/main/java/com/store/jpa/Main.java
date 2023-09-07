package com.store.jpa;

import java.math.BigDecimal;

import com.store.jpa.dao.CategoryDAO;
import com.store.jpa.dao.ProductDAO;
import com.store.jpa.model.Category;
import com.store.jpa.model.Product;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		Category computer = new Category("Computer");
		Product HPLaptop = new Product("HP Laptop", "Powerfull laptop.", new BigDecimal("1200"), computer);

		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
		
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		ProductDAO productDAO = new ProductDAO(entityManager);
		
		categoryDAO.add(computer);
		productDAO.add(HPLaptop);
		
		entityManager.flush();
		entityManager.clear();
		
		HPLaptop.setDescription("Intel Core i3, 8gb RAM.");
		
		productDAO.update(HPLaptop);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
