package com.codes.SpringBoot.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codes.SpringBoot.Entities.User;
import com.codes.SpringBoot.Response.ResponseObj;
import com.codes.SpringBoot.Service.UserServiceImpl;
import com.codes.SpringBoot.Services.UserRegistrationService;

@RestController
public class index {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRegistrationService userRegistrationService;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

            return new ResponseEntity<>(userDetails.getPassword(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/home")
    public String getMethodName(@RequestParam(value = "user") String user) {
        return "Welcome " + user;
    }

    @GetMapping("/office")
    public String getOffice(@RequestParam(value = "user") String user) {
        return "Welcome " + user;
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseObj> registerNewUser(@RequestBody User newUser) {
        try {
            var response = userRegistrationService.registerUser(newUser);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception (you can use a logger instead of System.out for production)
            System.err.println("Error registering user: " + e.getMessage());
            // Return a 500 Internal Server Error response with a message
            return ResponseEntity.status(500).body(new ResponseObj("Error registering user: " + e.getMessage()));
        }
    }
}
