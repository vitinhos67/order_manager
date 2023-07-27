package com.ordermanager.models.entitys;


import java.util.Date;
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
	private Date created_at;

	public Order(int id, List<Item> itens) {
		super();
		this.id = id;
		this.itens = itens;
		this.setCreated_at(new Date());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	
	
	
}
