package com.ordermanager.services;

import com.ordermanager.dtos.Authentication.RegisterDTO;
import com.ordermanager.exceptions.UserFoundException;

import com.ordermanager.models.entitys.User;
import com.ordermanager.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {


    @Value("${account.mail.confirmation.enable}")
    private Boolean enableConfirmationAccount;

    @Autowired
    UserService userService;

    @Autowired
    SenderEmailService senderEmailService;

    public User register(RegisterDTO data) {


        User findUser = this.userService.findByEmail(data.email());

        if(findUser != null) {
            throw new UserFoundException("User already in use");
        }

        User new_user = this.userService.registerUser(data);

        try {

            if(enableConfirmationAccount) {
                this.senderEmailService.sendEmail(data.email(), "Account Verification", "TESTE1");
            }

            return new_user;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



}
