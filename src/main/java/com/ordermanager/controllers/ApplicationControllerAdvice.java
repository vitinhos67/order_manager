package com.ordermanager.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ordermanager.exceptions.AccessDeniedExceptionHandler;
import com.ordermanager.exceptions.ItemNotFoundException;
import com.ordermanager.exceptions.OrderNotFoundException;
import com.ordermanager.exceptions.UserNotFoundException;

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
    	
    	System.out.print("Aqui?");
    	
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
      logger.error("Request: " + req.getRequestURL() + " raised " + ex);

      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", ex);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName("error");
      return mav;
    }


}
