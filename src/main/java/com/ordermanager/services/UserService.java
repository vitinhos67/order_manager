package com.ordermanager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.models.entitys.User;
import com.ordermanager.models.repositorys.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	

	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	
	public User createUser(User user) {
	user.setPassword(hashPassword(user.getPassword()));
	this.userRepository.save(user);
	return user;
	}

	
	public List<User> allUsers() {
		return (List<User>) this.userRepository.findAll();
	}


	public Optional<User> findUserById(int id) {
		return this.userRepository.findById(id);
	}
	
	
}
