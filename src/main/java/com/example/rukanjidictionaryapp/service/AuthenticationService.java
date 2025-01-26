package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.dto.JwtAuthenticationResponse;
import com.example.rukanjidictionaryapp.dto.SignInRequest;
import com.example.rukanjidictionaryapp.dto.SignUpRequest;
import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signUp(SignUpRequest signUpRequest) {

        var user = User.builder()
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(UserRole.ROLE_USER)
                .build();

        userService.save(user);

        return new JwtAuthenticationResponse(jwtService.generateToken(user));
    }

    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(), signInRequest.getPassword()
        ));

        var user = userService.getUserDetailsService().loadUserByUsername(signInRequest.getUsername());

        return new JwtAuthenticationResponse(jwtService.generateToken(user));
    }



}
