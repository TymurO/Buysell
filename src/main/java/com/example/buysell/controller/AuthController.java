package com.example.buysell.controller;

import com.example.buysell.dto.JwtRequest;
import com.example.buysell.dto.JwtResponse;
import com.example.buysell.dto.RegistrationUserDto;
import com.example.buysell.dto.UserDto;
import com.example.buysell.exception.AppError;
import com.example.buysell.module.User;
import com.example.buysell.service.AuthService;
import com.example.buysell.service.UserDetailsService;
import com.example.buysell.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/reg")
    public ResponseEntity<?> createUser(RegistrationUserDto registrationUserDto) {
        return authService.createUser(registrationUserDto);
    }

    @GetMapping("/reg")
    public String getRegFrom() {
        return "reg";
    }

    @GetMapping("/log")
    public String getLogForm() {
        return "login";
    }
}
