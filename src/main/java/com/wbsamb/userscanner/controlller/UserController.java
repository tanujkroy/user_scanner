package com.wbsamb.userscanner.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/editUser")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        return userService.editUser(user);       
    }

    @GetMapping("/fetchMyDetails")
    public ResponseEntity<?> fetchMyDetails() {
        return userService.fetchMyDetails();       
    }

    @GetMapping("/fetchMyQrCode")
    public ResponseEntity<?> fetchMyQrCode() {
        return userService.fetchMyQrCode();       
    }

}
