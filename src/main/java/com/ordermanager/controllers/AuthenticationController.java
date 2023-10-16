package com.ordermanager.controllers;

import com.ordermanager.configs.security.TokenService;
import com.ordermanager.dtos.Authentication.LoginResponseDTO;
import com.ordermanager.dtos.Authentication.RegisterDTO;
import com.ordermanager.models.entitys.AuthenticationDTO;
import com.ordermanager.models.entitys.User;
import com.ordermanager.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	TokenService tokenService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
			
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public User register(@RequestBody RegisterDTO user) {
		return this.authenticationService.register(user);
	}

	
}
