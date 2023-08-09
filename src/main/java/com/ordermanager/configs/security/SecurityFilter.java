package com.ordermanager.configs.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ordermanager.services.user.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenService tokenService;
	
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		var token = retrieveToken(request);
		
		
		if(token != null) {
			var subject = tokenService.validateToken(token);
			
			UserDetails user = userService.findByEmail(subject);
			
			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		filterChain.doFilter(request, response);
		
		
	}
	
	/**
	 * Retrieve the user's token
	 * @param request
	 * @return
	 */
	private String retrieveToken(HttpServletRequest request) {
	    String token = request.getHeader("Authorization");
	    if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
	        return null;
	    }
	    return token.replace("Bearer ", "");
	}
	


}
