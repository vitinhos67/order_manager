package com.ordermanager.services;

import com.ordermanager.models.entitys.User;
import com.ordermanager.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountVerificationService {

    @Autowired
    UserService userService;

    public User accountVerification(Integer id) {
        User user = this.userService.updateVerification(id);
        return user;
    }


}
