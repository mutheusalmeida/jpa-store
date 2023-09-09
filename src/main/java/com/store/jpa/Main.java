package com.store.jpa;

import java.math.BigDecimal;
import java.util.List;

import com.store.jpa.dao.ClientDAO;
import com.store.jpa.dao.ProductDAO;
import com.store.jpa.model.Client;
import com.store.jpa.model.Product;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ClientDAO clientDAO = new ClientDAO(entityManager);
		
		Client bob = clientDAO.getClient(2l);
		
		System.out.println(bob.getName());
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
