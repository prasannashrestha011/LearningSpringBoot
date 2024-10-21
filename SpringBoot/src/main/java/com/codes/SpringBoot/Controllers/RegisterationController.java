package com.codes.SpringBoot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codes.SpringBoot.Entities.User;
import com.codes.SpringBoot.Response.ResponseObj;
import com.codes.SpringBoot.Services.UserRegistrationService;

@RestController
@RequestMapping("/register")
public class RegisterationController {
    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping("/user")
    public ResponseEntity<ResponseObj> registerNewUser(User newUser) {
        var response = userRegistrationService.registerUser(newUser);
        System.out.println("asdfasdfsadfsadfasdfsdfasdfasfs");
        return ResponseEntity.ok(response);
    }
}
