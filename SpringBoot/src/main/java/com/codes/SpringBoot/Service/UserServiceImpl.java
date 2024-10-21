package com.codes.SpringBoot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.codes.SpringBoot.Entities.User;
import com.codes.SpringBoot.Repository.UserRepository;
import com.codes.SpringBoot.Response.ResponseObj;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(@RequestParam(value = "id") int id) {
        try {
            Optional<User> targetedUser = userRepository.findById(id);
            if (!targetedUser.isPresent()) {
                throw new Exception("user not found");
            }
            return targetedUser.get();

        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            var savedUsers = userRepository.findAll();
            if (savedUsers.isEmpty()) {
                throw new Exception("List is empty");

            }
            return savedUsers;
        } catch (Exception err) {
            System.out.println(err.getMessage());
            return null;
        }
    }

    @Override
    public ResponseObj createUser(User user) {
        userRepository.save(user);
        var message = new ResponseObj("user created");
        return message;
    }

}
