package com.ordermanager.exceptions.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
  
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(int id) {
		super("Item not found with ID: " + id);
    }

	
	
	
	
}
