package com.ordermanager.dtos.Authentication;

import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.user.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role, Address address) {

}
