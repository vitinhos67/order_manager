package com.ordermanager.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.User;
import com.ordermanager.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService; 
	
	public UserController() {
		setUserService();
	}
	
	private void setUserService() {
		this.userService = new UserService();
	}
	
	
	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) throws Exception {
			this.userService.createUser(user);		
			return user;
	}
	
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> allUsers() throws Exception {
		return this.userService.allUsers();
	}
	
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public Optional<User> findUserById(@PathVariable int id) throws Exception {
		return this.userService.findUserById(id);
	}
	
}
