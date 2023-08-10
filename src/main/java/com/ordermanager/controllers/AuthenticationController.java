package com.ordermanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ordermanager.configs.security.TokenService;
import com.ordermanager.dtos.Authentication.LoginResponseDTO;
import com.ordermanager.dtos.Authentication.RegisterDTO;
import com.ordermanager.models.entitys.AuthenticationDTO;
import com.ordermanager.models.entitys.User;
import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	
	@Autowired
	private AuthenticationManager authenticationManagager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	TokenService tokenService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
			
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		
		
		
		var auth = this.authenticationManagager.authenticate(usernamePassword);
		

		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data) {
		
		try {
			
			if(this.userService.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
			
			String hashPassword = new BCryptPasswordEncoder().encode(data.password());
			
		
			Address newAddress = new Address(data.address().getStreet(), 
					data.address().getCity(), data.address().getState(), data.address().getCep());
			
			
			User newUser = new User(data.name(),data.email(), hashPassword, data.role(), newAddress);
			
			
			
			this.userService.createUser(newUser);
			 			
			return ResponseEntity.ok(newUser);
		} catch (Exception e) {		
			System.out.print("ot aqui?");
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	
}
