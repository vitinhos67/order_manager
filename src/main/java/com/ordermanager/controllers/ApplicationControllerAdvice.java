package com.ordermanager.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ordermanager.exceptions.ItemNotFoundException;
import com.ordermanager.exceptions.UserNotFoundException;




@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(ItemNotFoundException.class)
	  public ResponseEntity<String> handleNotFoundException(ItemNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(UserNotFoundException.class)
	  public ResponseEntity<String> handleNotFoundException(UserNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
	

}
