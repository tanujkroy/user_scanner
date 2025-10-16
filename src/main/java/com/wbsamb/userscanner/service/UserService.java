package com.wbsamb.userscanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wbsamb.userscanner.config.ResponseHandler;
import com.wbsamb.userscanner.model.User;
import com.wbsamb.userscanner.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> addUser(User user) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setStatus(true);
      userRepository.save(user);
       return ResponseHandler.generateResponse("successfully saved", HttpStatus.OK, null);
    }
    
}
