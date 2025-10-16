package com.wbsamb.userscanner.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.wbsamb.userscanner.config.jwt.JwtUtil;
import com.wbsamb.userscanner.serviceImpl.TokenRevocationService;

import jakarta.annotation.Nullable;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {

    private final TokenRevocationService TokenRevocationService;

    private final JwtUtil jwtUtil;

    public JwtLogoutSuccessHandler(TokenRevocationService TokenRevocationService, JwtUtil jwtUtil) {
        this.TokenRevocationService = TokenRevocationService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, @Nullable Authentication arg2)
            throws IOException, ServletException {
        String extractToken = jwtUtil.extractToken(request);
        TokenRevocationService.revokeToken(extractToken);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("Logout Successful");
        response.getWriter().flush();
    }

}
