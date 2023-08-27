package com.ordermanager.exceptions;


public class AccessDeniedExceptionHandler extends RuntimeException {

	  
	
		private static final long serialVersionUID = 1L;

		public AccessDeniedExceptionHandler(String message) {
			super(message);
	    }
		
}
