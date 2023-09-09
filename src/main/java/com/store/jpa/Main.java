package com.store.jpa;

import com.store.jpa.dao.OrderDAO;
import com.store.jpa.model.Order;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		OrderDAO orderDAO = new OrderDAO(entityManager);
		
		Order order = orderDAO.getOrderWithClient(2l);
		
		System.out.println(order.getTotalValue());
		
		entityManager.getTransaction().commit();
		entityManager.close();
				
		System.out.println(order.getClient().getName());
	}
}
