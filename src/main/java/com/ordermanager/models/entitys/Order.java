package com.ordermanager.models.entitys;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name = "pedidos")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@OneToMany
	private List<Item> itens;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
