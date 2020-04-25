package com.security.jwt.controller;

import com.security.jwt.auth.TokenManager;
import com.security.jwt.dto.LoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    TokenManager tokenManager;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

            return ResponseEntity.ok(tokenManager.generateToken(loginRequestDTO.getUsername()));
        } catch (Exception e) {
            throw e;
        }
    }
}
