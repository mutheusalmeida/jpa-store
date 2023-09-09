package com.store.jpa;

import java.math.BigDecimal;

import com.store.jpa.dao.CategoryDAO;
import com.store.jpa.dao.ClientDAO;
import com.store.jpa.dao.OrderDAO;
import com.store.jpa.dao.ProductDAO;
import com.store.jpa.model.Category;
import com.store.jpa.model.Client;
import com.store.jpa.model.Order;
import com.store.jpa.model.OrderItem;
import com.store.jpa.model.Product;
import com.store.jpa.util.JPAUtil;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ProductDAO productDAO = new ProductDAO(entityManager);
		ClientDAO clientDAO = new ClientDAO(entityManager);
		OrderDAO orderDao = new OrderDAO(entityManager);
		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		
		Category computer = categoryDAO.getCategoryByName("Computer");

		Product mouse = new Product("HP Mouse", "A gamer mouse.", new BigDecimal("150"), computer);
		
		Client smith = new Client("Smith", "24364578412");
		Order order = new Order(smith);
		order.addOrderItem(new OrderItem(32, mouse, order));
		
		productDAO.add(mouse);
		clientDAO.add(smith);
		orderDao.add(order);
		
		BigDecimal totalValue = orderDao.getTotalValue();
		
		System.out.println(totalValue);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
