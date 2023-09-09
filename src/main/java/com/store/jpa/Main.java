package com.store.jpa;

import com.store.jpa.dao.ProductDAO;
import com.store.jpa.model.Device;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ProductDAO productDAO = new ProductDAO(entityManager);
		
		Device iPhone14 = (Device) productDAO.getProduct(10l);
		
		System.out.println(iPhone14.getModel());
		System.out.println(iPhone14.getBrand());
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
