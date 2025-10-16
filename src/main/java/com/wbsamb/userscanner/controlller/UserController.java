package com.wbsamb.userscanner.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbsamb.userscanner.model.User;
import com.wbsamb.userscanner.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
     @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
             return userService.addUser(user);       
    }
}
