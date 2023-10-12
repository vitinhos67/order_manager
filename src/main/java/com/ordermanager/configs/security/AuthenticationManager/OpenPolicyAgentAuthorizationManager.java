package com.ordermanager.configs.security.AuthenticationManager;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import com.ordermanager.OrderManagerApplication;
import com.ordermanager.configs.security.TokenService;
import com.ordermanager.services.user.UserService;

@Component
public class OpenPolicyAgentAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
	
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	UserService userService;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(OrderManagerApplication.class);
	
	
	public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
		
		
		String authorization = object.getRequest().getHeader("Authorization");		
		
		 if(authorization == null || authorization.isEmpty() ||
			!authorization.startsWith("Bearer ")) {
			throw new AccessDeniedException("Access denied");
		 }
		
		
		String bearerString = authorization.split(" ")[1];
		
		String user = tokenService.validateToken(bearerString);
		
		
		if(user.isEmpty()) {
			return new AuthorizationDecision(false);
		}
		
		UserDetails findUser = userService.findByEmail(user);
		
		if(findUser == null) {		
			throw new AccessDeniedException("Access Denied");
		}
					
			
			return null;
			
	}
	
}
