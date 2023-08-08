package com.ordermanager.models.entitys;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ordermanager.services.ItemService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;


@Entity(name = "orders")
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "pedido_item",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens;
	private Date created_at;
	private String description;
	

	@Autowired
	@Transient
	private ItemService itemService;
		
	
	public Order(List<Item> itens) {
		super();
		this.itens = itens;
		this.created_at = new Date();
	}
	
	
	public Order() {
	// TODO Auto-generated constructor stub
	}
	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
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

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	
}
