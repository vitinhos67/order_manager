package com.ordermanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.models.entitys.User;
import com.ordermanager.models.repositorys.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	

	public User createUser(User user) {
	this.userRepository.save(user);
	return user;
	}
	
	
}
