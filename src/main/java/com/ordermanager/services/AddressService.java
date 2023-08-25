package com.ordermanager.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.models.entitys.User;
import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.user.UserService;

@Service
public class AddressService {
	
	@Autowired
	UserService userService;
	
	
	
	public User addAddressToUser(Address address, int id) {
		
		User findUser = this.userService.findUserById(id);

		findUser.setAddress(address);
		return this.userService.createUser(findUser);
		
	
		
		
		
		
		
	}
	
}
