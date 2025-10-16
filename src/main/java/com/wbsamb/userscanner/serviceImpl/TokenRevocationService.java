package com.wbsamb.userscanner.serviceImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wbsamb.userscanner.config.jwt.JwtUtil;

@Service
public class TokenRevocationService {
     @Autowired
    private JwtUtil jwtUtil;

    private Set<String> revokedTokens = new HashSet<>();

    public boolean isTokenRevoked(String token) {
        return revokedTokens.contains(token);
    }

    public void revokeToken(String token) {
        revokedTokens.add(token);
    }

    @Scheduled(cron = "0/10 * * * * ?")
    private void cleanupExpiredTokens() {
        // Remove expired tokens from the set
        Iterator<String> iterator = revokedTokens.iterator();
        while (iterator.hasNext()) {
            String revokedToken = iterator.next();
            try {
                Date expiration = jwtUtil.extractExpiration(revokedToken);
                if (expiration.before(new Date())) {
                    iterator.remove();
                }
            } catch (Exception e) {

            }

        }
    } 
}

