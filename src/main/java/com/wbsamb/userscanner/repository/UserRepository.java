package com.wbsamb.userscanner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wbsamb.userscanner.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
}
