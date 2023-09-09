package com.store.jpa;

import java.math.BigDecimal;
import java.util.List;

import com.store.jpa.dao.ProductDAO;
import com.store.jpa.model.Product;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ProductDAO productDAO = new ProductDAO(entityManager);
		
		List<Product> products = productDAO.getProductsByParams(null, null, null);
		
		products.forEach(p -> System.out.println(p.getName()));
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
