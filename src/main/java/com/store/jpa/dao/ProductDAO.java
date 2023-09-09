package com.store.jpa.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.store.jpa.model.Product;
import com.store.jpa.vo.SalesReportVo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductDAO {
	private EntityManager entityManager;

	public ProductDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private Product manage(Product product) {
		return this.entityManager.merge(product);
	}
	
	public void add(Product product) {
		this.entityManager.persist(product);
	}

	public void delete(Product product) {
		this.entityManager.remove(this.manage(product));
	}

	public void update(Product product) {
		this.manage(product);
	}
	
	public Product getProduct(Long id) {
		return this.entityManager.find(Product.class, id);
	}
	
	public List<Product> getProducts() {
		String jpql = "SELECT p FROM Product p";
		
		return this.entityManager.createQuery(jpql, Product.class).getResultList();
	}
	
	public List<Product> getProductsByName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.name = :name";
		
		return this.entityManager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
	}
	
	public List<Product> getProductsByCategory(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
		
		return this.entityManager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
	}
	
	public BigDecimal getProductPrice (String name) {
		String jpql = "SELECT p.price FROM Product p WHERE p.name = :name";
		
		return this.entityManager.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
	}
	
	public List<SalesReportVo> getSalesReport() {
		String jpql = "SELECT new com.store.jpa.vo.SalesReportVo("
				+ "product.name, "
				+ "SUM(orderItem.quantity) as quantity, "
				+ "MAX(order.date)) "
				+ "FROM Order order "
				+ "JOIN order.orderItems orderItem "
				+ "JOIN orderItem.product product "
				+ "GROUP BY product.name "
				+ "ORDER BY quantity DESC";
		
		return this.entityManager.createQuery(jpql, SalesReportVo.class).getResultList();
	}
	
	public List<Product> getProductsByParams(String name, BigDecimal price, LocalDate date) {
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		
		Predicate predicate = criteriaBuilder.and();
		
		if (name != null && !name.equals("")) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), name));
		}
		
		if (price != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("price"), price));
		}
		
		if (date != null) {
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), date));
		}
		
		criteriaQuery.where(predicate);
		
		return this.entityManager.createQuery(criteriaQuery).getResultList();
	}
	
}
