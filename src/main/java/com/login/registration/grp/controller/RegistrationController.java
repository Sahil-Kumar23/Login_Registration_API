package com.login.registration.grp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.registration.grp.component.RegistrationRequest;
import com.login.registration.grp.modal.User;
import com.login.registration.grp.service.UserService;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {
	
	@Autowired
    private UserService userService;
	
	@PostMapping
    public ResponseEntity<String> register(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.isEmailAlreadyRegistered(registrationRequest.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getUsername());
        
        userService.registerUser(user);
        return ResponseEntity.ok("Registration successful");
    }
}

