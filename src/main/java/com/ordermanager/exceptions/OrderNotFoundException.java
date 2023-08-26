package com.ordermanager.exceptions;

public class OrderNotFoundException extends RuntimeException {
  
	
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(int id) {
		super("Order not found with ID: " + id);
    }

	
	
	
	
}
