package com.ordermanager.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ordermanager.exceptions.notFound.UserNotFoundException;
import com.ordermanager.models.entitys.User;
import com.ordermanager.models.repositorys.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
		
	public User createUser(User user) {
		return this.userRepository.save(user);
	}

	
	public List<User> allUsers() {
		return (List<User>) this.userRepository.findAll();
	}


	public User findUserById(int id) {
		return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
	}
	
	public User updateUser(User user, int id) {
		
		User optionalUser = this.findUserById(id);

	    optionalUser.setName(user.getName());
	    optionalUser.setEmail(user.getEmail());
	    this.createUser(optionalUser);
	    return optionalUser;
	}
	
	
	public UserDetails findByEmail(String email) {

		UserDetails user = this.userRepository.findByEmail(email);

		if(user == null) {
			throw new UserNotFoundException("User not found");
		}

		return user;
	}
	
		
	
}
