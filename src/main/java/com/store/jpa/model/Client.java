package com.store.jpa.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "clients")
public class Client {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private PersonalData personalData;
	
	public Client() {
		
	}
	
	public Client(String name, String cpf) {
		this.personalData = new PersonalData(name, cpf);
	}

	public String getName() {
		return this.personalData.getName();
	}

	public String getCpf() {
		return this.personalData.getCpf();
	}
}
