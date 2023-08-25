package com.ordermanager.exceptions;

public class ItemNotFoundException extends RuntimeException {
  
	
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(int id) {
		super("Item not found with ID: " + id);
    }

	
	
	
	
}
