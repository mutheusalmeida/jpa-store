package com.store.jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("store");
			
	public static EntityManager getEntityManager () {
		return entityManagerFactory.createEntityManager();
	}

}
