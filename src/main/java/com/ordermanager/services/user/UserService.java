package com.ordermanager.services.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ordermanager.exceptions.UserNotFoundException;
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
		return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public User updateUser(User user, int id) throws Exception {
		
		User optionalUser = this.findUserById(id);

	    optionalUser.setName(user.getName());
	    optionalUser.setEmail(user.getEmail());
	   

	    this.createUser(optionalUser);
	    return optionalUser;
	}
	
	
	public UserDetails findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
		
	
}
