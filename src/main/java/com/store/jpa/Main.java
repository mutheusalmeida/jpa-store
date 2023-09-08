package com.store.jpa;

import java.math.BigDecimal;

import com.store.jpa.dao.ProductDAO;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ProductDAO productDAO = new ProductDAO(entityManager);

		BigDecimal iPhonePrice = productDAO.getProductPrice("iPhone 12");
		
		System.out.println(iPhonePrice);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
