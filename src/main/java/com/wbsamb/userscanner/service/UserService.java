package com.wbsamb.userscanner.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
  private QrCodeGenerateService qrCodeGenerateService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public ResponseEntity<?> addUser(User user) {
    try {
      if (userRepository.findByUsername(user.getUsername()).isPresent()) {
        return ResponseHandler.generateResponse("User already present", HttpStatus.BAD_REQUEST, null);
      }
      user.setPassword(passwordEncoder.encode(user.getRawPassword()));
      user.setStatus(true);
      User savedUser = userRepository.save(user);
      String qrPath = qrCodeGenerateService.generateQRCode(savedUser, 300, 300);
      savedUser.setQrCodePath(qrPath);
      savedUser.setQrCodeData(savedUser.getUsername());
      userRepository.save(savedUser);

      return ResponseHandler.generateResponse("Successfully registered with QR", HttpStatus.OK, savedUser);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }
  }

  public ResponseEntity<?> editUser(User user) {
    try {
      if (user.getRawPassword() != null)
        user.setPassword(passwordEncoder.encode(user.getRawPassword()));
      User save = userRepository.save(user);
      String qrPath = qrCodeGenerateService.generateQRCode(save, 300, 300);
      save.setQrCodePath(qrPath);
      save.setQrCodeData(save.getUsername());
      userRepository.save(save);
      return ResponseHandler.generateResponse("Successfully registered with QR", HttpStatus.OK, save);
    } catch (Exception e) {
      return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
    }

  }

  public ResponseEntity<?> fetchMyDetails() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> findByUsername = userRepository.findByUsername(authentication.getPrincipal().toString());

    if (findByUsername.isEmpty()) {
      return ResponseHandler.generateResponse("User Not Present", HttpStatus.NOT_FOUND, null);
    } else {
      return ResponseHandler.generateResponse("User", HttpStatus.OK, findByUsername);
    }
  }

  public ResponseEntity<?> fetchMyQrCode() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> findByUsername = userRepository.findByUsername(authentication.getPrincipal().toString());

    if (findByUsername.isEmpty()) {
      return ResponseHandler.generateResponse("User Not Present", HttpStatus.NOT_FOUND, null);
    } else {
      String qrCodePath = findByUsername.get().getQrCodePath();
      return ResponseHandler.generateResponse("User", HttpStatus.OK, qrCodePath);
    }
  }

}
