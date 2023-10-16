package com.ordermanager.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.User;
import com.ordermanager.services.user.UserService;

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
	
	
	@RequestMapping(path = "/user", method = {RequestMethod.POST})
	public User createUser(@Valid @RequestBody User user) {
			this.userService.createUser(user);
			return user;
	}

	@Cacheable(value = "users")
	@RequestMapping(path = "/users", method = RequestMethod.GET)
	public List<User> allUsers() {
		return this.userService.allUsers();
	}

	@Cacheable(value = "users")
	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public User findUserById(@PathVariable int id) {
		return this.userService.findUserById(id);
	}
	
	
	@RequestMapping(path = "/user/{id}", method = {RequestMethod.PUT})
	public User updateUser(@Valid @RequestBody User user, @PathVariable int id) {
			return this.userService.updateUser(user, id);
	}
	
	
}
