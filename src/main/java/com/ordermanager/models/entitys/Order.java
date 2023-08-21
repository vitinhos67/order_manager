package com.ordermanager.models.entitys;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.Item.ItemService;
import com.ordermanager.services.Order.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
    
    @Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private String description;
	private OrderStatus status;
	
	@JoinColumn(name = "user_id")
    private Integer userId; // Guarda o ID do usuário associado a este pedido
	
	
	
	@Embedded
	private Address address;
	
	

	@Autowired
	@Transient
	private ItemService itemService;
		
	
	public Order(List<Item> itens, int userId) {
		super();
		this.userId = userId;
		this.itens = itens;
		this.createdAt = new Date();
	}
	
	
	
	public OrderStatus getStatus() {
		return status;
	}

	

	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
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
		return createdAt;
	}

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setCreated_at(Date created_at) {
		this.createdAt = created_at;
	}



	
}
