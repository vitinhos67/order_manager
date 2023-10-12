package com.ordermanager.exceptions.notFound;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
  
	
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(int id) {
		super("Order not found with ID: " + id);
    }

	
	
	
	
}
