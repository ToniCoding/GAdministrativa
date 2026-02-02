package com.gadministrativa.security.service;

import com.gadministrativa.security.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    public String generateToken(String username) {
        return jwtTokenUtils.generateToken(username);
    }

    public Boolean validateToken(String token) {
        return jwtTokenUtils.validateToken(token);
    }

    public String extractUsername(String token) {
        return jwtTokenUtils.extractUsername(token);
    }
}
