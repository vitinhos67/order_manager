package com.ordermanager.configs.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.lang.NonNullApi;
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

			if(user != null) {

				String message = "{\"error\": \"User not found\", \"status\": \"401\"}";

				sendUnauthorizedResponse(response, message);
				return;
			}

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		filterChain.doFilter(request, response);
		
		
	}

	private String retrieveToken(HttpServletRequest request) {
	    String token = request.getHeader("Authorization");
	    if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
	        return null;
	    }
	    return token.replace("Bearer ", "");
	}
	
	private void sendUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    response.setContentType("application/json");

	    response.getWriter().write(message);
	}
	


}
