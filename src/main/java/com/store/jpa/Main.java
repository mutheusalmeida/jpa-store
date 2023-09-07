package com.store.jpa;

import java.math.BigDecimal;

import com.store.jpa.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Product cellphone = new Product();
		cellphone.setName("Xiaomi Redmi 12");
		cellphone.setDescription("Cool cellphone");
		cellphone.setPrice(new BigDecimal("900"));
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(cellphone);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
