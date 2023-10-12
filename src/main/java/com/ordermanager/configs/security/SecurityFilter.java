
package com.ordermanager.configs.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.filter.OncePerRequestFilter;

import com.ordermanager.services.user.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/api/*")
public class SecurityFilter extends OncePerRequestFilter {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SecurityFilter.class);
	

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info(
          "Starting a transaction for req : {}", 
          req.getRequestURI());


		var token = retrieveToken(request);

		if (token != null) {
			var subject = tokenService.validateToken(token);

			UserDetails user = userService.findByEmail(subject);

			if (user == null) {
				sendUnauthorizedResponse(response);
				return;
			}

			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);

		} else {
			sendUnauthorizedResponse(response);
			return;
		}

		filterChain.doFilter(request, response);
		
        logger.info(
                "Committing a transaction for req : {}", 
                req.getRequestURI());

      		

	}

	private String retrieveToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.replace("Bearer ", "");
	}

	private void sendUnauthorizedResponse(HttpServletResponse response) throws IOException {
		String message = "{\"error\": \"Access Denied\", \"status\": \"401\"}";

		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");

		response.getWriter().write(message);
	}
	
	
	

}
