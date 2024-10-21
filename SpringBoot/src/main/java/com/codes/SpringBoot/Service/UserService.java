package com.codes.SpringBoot.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.codes.SpringBoot.Entities.User;

import com.codes.SpringBoot.Response.ResponseObj;

public interface UserService {

    User getUserById(int id);

    List<User> getAllUsers();

    ResponseObj createUser(User user);

    UserDetails getUserByUserName(String user);
}
