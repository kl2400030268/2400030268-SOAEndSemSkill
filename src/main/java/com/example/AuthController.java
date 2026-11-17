package com.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest request) {
        return jwtUtil.generateToken(request.getUsername());
    }
}