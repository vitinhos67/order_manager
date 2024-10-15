package com.ordermanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.models.entitys.User;
import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.AddressService;

@RestController
@RequestMapping(path = "/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping
	public ResponseEntity<User> addAddressToUser(@RequestBody Address address, @RequestParam("id") int id) {

		User addAddress = this.addressService.addAddressToUser(address, id);
		return ResponseEntity.status(HttpStatus.OK).body(addAddress);

	}

}
