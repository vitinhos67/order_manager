package com.ordermanager.services.user;

import com.ordermanager.dtos.Authentication.RegisterDTO;
import com.ordermanager.exceptions.notFound.UserNotFoundException;
import com.ordermanager.models.entitys.User;
import com.ordermanager.models.repositorys.UserRepository;
import com.ordermanager.services.SenderEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private SenderEmailService senderEmailService;


		
	public User createUser(User user) {

			User new_user = this.userRepository.save(user);
			return new_user;

	}


	public User registerUser(RegisterDTO user) {
		User userObject = new User(user.name(), user.email(), user.password(), user.role(), null);
		return this.userRepository.save(userObject);
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

	public User updateVerification(Integer id) {

		User user = this.findUserById(id);
		user.setVerifiedAccount(Boolean.TRUE);

		return user;

	}

	
	
	public User findByEmail(String email) {
		User user = this.userRepository.findByEmail(email);
		return user;
	}
	
		
	
}
