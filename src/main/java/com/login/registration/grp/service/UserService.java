package com.login.registration.grp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.registration.grp.jpa_repo.UserRepository;
import com.login.registration.grp.modal.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public boolean isEmailAlreadyRegistered(String email) {
        User existingUser = userRepository.findByEmail(email);
        return existingUser != null;
    }
    
    public void registerUser(User user) {
        userRepository.save(user);
    }
    
    public String getPasswordByEmail(String email) {
    	User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword();
        } else {
            return null;
        }
    }
    
    public String checkEmailWithPassword(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            String storedPassword = user.getPassword();
            
            if (password.equals(storedPassword)) {
                return "Login successful";
            } else {
                return "Incorrect password";
            }
        } else {
            return "Email not found";
        }
    }
}

