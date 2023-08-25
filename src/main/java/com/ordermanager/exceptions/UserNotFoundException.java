package com.ordermanager.exceptions;

public class UserNotFoundException extends RuntimeException {
  
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id) {
		super("User not found with ID: " + id);
    }

	
	
	
	
}
