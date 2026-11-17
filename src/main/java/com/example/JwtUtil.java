package com.example;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private final String secret = "MySecretKeyForJWTGeneration1234567890";

    public String generateToken(String username) {

        SecretKey key = Keys.hmacShaKeyFor(
            secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(username)
                .signWith(key)
                .compact();
    }
}