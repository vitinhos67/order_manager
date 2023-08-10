package com.ordermanager.models.entitys.Embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
    private String street;
    private String city;
    private String state;
    private String cep;
	
    public Address() {
		// TODO Auto-generated constructor stub
	}
    
    
    public Address(String street, String city, String state, String cep) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.cep = cep;
	}
	
    public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", cep=" + cep + "]";
	}
	

    
    
    
	
}
