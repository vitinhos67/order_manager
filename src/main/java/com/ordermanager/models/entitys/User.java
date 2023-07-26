package com.ordermanager.models.entitys;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Date created_at;
	private String password;
	
	
	
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.created_at =  new Date();
	}

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}

	private String hashPassword(String password) {	
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
}
