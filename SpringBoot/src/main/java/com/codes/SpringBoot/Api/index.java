package com.codes.SpringBoot.Api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codes.SpringBoot.Entities.User;

import com.codes.SpringBoot.Repository.UserRepository;
import com.codes.SpringBoot.Response.ResponseObj;

@RestController
public class index {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create/user")
    public ResponseEntity<ResponseObj> createUser(@RequestBody User user) {

        userRepository.save(user);
        var responseObj = new ResponseObj("new user created");
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/get/all/user")
    public ResponseEntity<List<User>> getAllUsers() {
        var savedUsers = userRepository.findAll();
        return ResponseEntity.ok(savedUsers);
    }

    @GetMapping("/get/user")
    public ResponseEntity<Optional<User>> getUserById(@RequestParam(value = "id") int id) {
        var targetedUser = userRepository.findById(id);
        return ResponseEntity.ok(targetedUser);
    }
}
