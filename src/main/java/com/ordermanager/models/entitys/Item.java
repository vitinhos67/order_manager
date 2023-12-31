package com.ordermanager.models.entitys;

import java.util.Date;
import java.util.List;

import com.ordermanager.services.Item.ItemStatus;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Item {
	
	public Item() {
	// TODO Auto-generated constructor stub
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private double price;
	private ItemStatus status;
	private String category;
	
	@ElementCollection
	private List<String> ingredients;
	
	@JoinColumn(name = "order_id")
	@ManyToOne
	private Order order;
	
	private Date created_at;
	
	
	public Item(Integer id,String name, String description, double price, List<String> ingredients, String category, ItemStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.category = category;
		
		setIngredients(ingredients);
		setCreated_at(new Date());

	}
	
	public String getCategory() {
		return category;
	}



	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}



	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public Item(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;

	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
