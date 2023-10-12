package com.ordermanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AccessDeniedExceptionHandler extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public AccessDeniedExceptionHandler(String message) {
			super(message);
	    }
		
}
