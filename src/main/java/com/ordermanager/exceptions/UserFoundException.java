package com.ordermanager.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.FOUND)
public class UserFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;
	public UserFoundException(String message) {
		super(message);
    }

	
}
