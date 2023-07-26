package com.ordermanager.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.User;

@RestController
public class DefaultController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		
		
		User user1 = new User("123", "123", "123");
		
		
		return "Essa String";
	}
	
}
