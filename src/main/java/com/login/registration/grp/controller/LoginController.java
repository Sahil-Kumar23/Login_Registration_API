package com.login.registration.grp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.registration.grp.component.LoginRequest;
import com.login.registration.grp.service.UserService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        String loginResult = userService.checkEmailWithPassword(email, password);

        if (loginResult.equals("Login successful")) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body(loginResult);
        }
        
    }
}
