package com.store.jpa;

import java.util.List;

import com.store.jpa.dao.ProductDAO;
import com.store.jpa.util.JPAUtil;
import com.store.jpa.vo.SalesReportVo;

import jakarta.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		entityManager.getTransaction().begin();
	
		ProductDAO productDAO = new ProductDAO(entityManager);
		
		List<SalesReportVo> salesReportVo = productDAO.getSalesReport();
		
		salesReportVo.forEach(s -> System.out.println(s));
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
