package com.store.jpa.dao;

import com.store.jpa.model.Client;

import jakarta.persistence.EntityManager;

public class ClientDAO {
	private EntityManager entityManager;

	public ClientDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void add(Client client) {
		this.entityManager.persist(client);
	}

	public Client getClient(Long id) {
		return this.entityManager.find(Client.class, id);
	}
}
