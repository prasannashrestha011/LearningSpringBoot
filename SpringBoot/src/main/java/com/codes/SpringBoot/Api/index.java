package com.codes.SpringBoot.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codes.SpringBoot.Entities.User;

import com.codes.SpringBoot.Response.ResponseObj;
import com.codes.SpringBoot.Service.UserServiceImpl;

@RestController
public class index {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/login")
    public String LoginUser() {
        return "you are authenticated ";
    }

    @GetMapping("/home")
    public String getMethodName(@RequestParam(value = "user") String user) {
        return "Welcome " + user;
    }

    @PostMapping("/create/user")
    public ResponseEntity<ResponseObj> createUser(@RequestBody User user) {

        userService.createUser(user);
        var responseObj = new ResponseObj("new user created");
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping("/get/all/users")
    public ResponseEntity<List<User>> getAllUsers() {
        var savedUsers = userService.getAllUsers();
        return ResponseEntity.ok(savedUsers);
    }

    @GetMapping("/get/user")
    public ResponseEntity<User> getUserById(@RequestParam(value = "id") int id) {
        var targetedUser = userService.getUserById(id);
        return ResponseEntity.ok(targetedUser);
    }
}
