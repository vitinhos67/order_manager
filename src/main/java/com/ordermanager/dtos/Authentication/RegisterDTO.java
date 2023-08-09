package com.ordermanager.dtos.Authentication;

import com.ordermanager.services.user.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {

}
