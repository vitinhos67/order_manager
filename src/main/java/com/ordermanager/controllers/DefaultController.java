package com.ordermanager.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home() {
		return "Essa String";
	}
	
}
