package com.ordermanager.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ordermanager.exceptions.AccessDeniedExceptionHandler;
import com.ordermanager.exceptions.notFound.ItemNotFoundException;
import com.ordermanager.exceptions.notFound.OrderNotFoundException;
import com.ordermanager.exceptions.notFound.UserNotFoundException;

import jakarta.servlet.http.HttpServletRequest;




@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler({OrderNotFoundException.class, ItemNotFoundException.class, UserNotFoundException.class})
	  public ResponseEntity<String> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
    @ExceptionHandler({ AccessDeniedExceptionHandler.class })
    public ResponseEntity<String> handleAccessDeniedException(
      AccessDeniedExceptionHandler ex) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
    



}
