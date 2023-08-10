package com.ordermanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.common.errors.ItemNotFoundException;
import com.ordermanager.models.entitys.User;
import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.user.UserService;

@Service
public class AddressService {
	
	@Autowired
	UserService userService;
	
	
	
	public User addAddressToUser(Address address, int id) {
		
		Optional<User> findUser = this.userService.findUserById(id);
		
		
		if(!findUser.isPresent()) {
			throw new ItemNotFoundException("Usario not found");
		}
		
		
		findUser.get().setAddress(address);
		
		return this.userService.createUser(findUser.get());
		
	
		
		
		
		
		
	}
	
}
