package com.bridgelabz.hospital_management_system.service;

import com.bridgelabz.hospital_management_system.config.JwtService;
import com.bridgelabz.hospital_management_system.dto.AuthRequest;
import com.bridgelabz.hospital_management_system.dto.AuthResponse;
import com.bridgelabz.hospital_management_system.entity.Role;
import com.bridgelabz.hospital_management_system.entity.User;
import com.bridgelabz.hospital_management_system.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// uc5: create service layer
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // User Registration
    public String registerUser(AuthRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);

        userRepository.save(user);

        return "User registered successfully";
    }

    // User Login
    public AuthResponse loginUser(AuthRequest request) {

        authenticate(request.getEmail(), request.getPassword());

        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponse(
                token,
                "Login successful",
                request.getEmail()
        );
    }

    // Authenticate User
    public Authentication authenticate(String email, String password) {

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );
    }
}
