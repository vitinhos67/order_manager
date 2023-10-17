package com.ordermanager.controllers;

import com.ordermanager.models.entitys.User;
import com.ordermanager.services.AccountVerificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/verification")
public class AccountVerificationController {


    AccountVerificationService accountVerificationService;

    @Autowired
    public AccountVerificationController(AccountVerificationService accountVerificationService) {
        this.accountVerificationService = accountVerificationService;
    }


    @GetMapping
    public ResponseEntity<User> accountVerification(@RequestParam @Valid Integer id) {
        User response = this.accountVerificationService.accountVerification(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
