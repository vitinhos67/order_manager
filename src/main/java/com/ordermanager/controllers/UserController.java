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
	
	
	@RequestMapping(path = "/user", method = {RequestMethod.POST})
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
	
	
	@RequestMapping(path = "/user/{id}", method = {RequestMethod.PUT})
	public User updateUser(@Valid @RequestBody User user, @PathVariable int id) throws Exception {
			
			
		
			Optional<User> optionalUser = this.userService.findUserById(id);
		
		    if (!optionalUser.isPresent()) {
		        throw new Exception("User not found");
		    } 

		    User user1 = optionalUser.get();
		    user1.setName(user.getName());
		    user1.setEmail(user.getEmail());
		    // Atualize outros campos conforme necessário

		    this.userService.createUser(user1); // Atualiza o usuário no banco de dados

		    return user1;
	}
	
	
}
