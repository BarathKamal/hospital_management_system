package com.bridgelabz.hospital_management_system.controller;

import com.bridgelabz.hospital_management_system.dto.AuthRequest;
import com.bridgelabz.hospital_management_system.dto.AuthResponse;
import com.bridgelabz.hospital_management_system.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// uc7:create controller layer
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Register User
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody AuthRequest request) {

        return ResponseEntity.ok(
                authService.registerUser(request)
        );
    }

    // Login User
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {

        return ResponseEntity.ok(
                authService.loginUser(request)
        );
    }
}
