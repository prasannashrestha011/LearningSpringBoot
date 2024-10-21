package com.codes.SpringBoot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codes.SpringBoot.Entities.User;
import com.codes.SpringBoot.Repository.UserRepository;
import com.codes.SpringBoot.Response.ResponseObj;

@Service
public class UserRegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseObj registerUser(User newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        return new ResponseObj("Your account has been registered");
    }
}
