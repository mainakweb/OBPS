package com.example.jwt.security;

import com.example.jwt.dto.LoginRequest;
import com.example.jwt.model.Auth;
import com.example.jwt.repository.AuthRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;
    @Autowired
    AuthRepository authRepository;

    public String generateToken(Authentication authentication, LoginRequest loginRequest) {
        String username = authentication.getName();
        List<Auth> authData = authRepository.findByVendorCode(username);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", authData.get(0).getUsername());
        claims.put("vendor_code", authData.get(0).getVendorCode());
        claims.put("name", authData.get(0).getName());
        claims.put("department_id", authData.get(0).getDepartmentId());
        claims.put("internal_role_id", authData.get(0).getInternalRoleId());
        claims.put("sub", "HR");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Map<String, Object> getCustomUserDetailsFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception ex) {
            // Log or handle the exception appropriately
        }
        return false;
    }
}

