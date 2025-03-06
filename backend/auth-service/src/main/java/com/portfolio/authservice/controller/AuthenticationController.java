package com.portfolio.authservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portfolio.authservice.dto.user.UserLoginRequestDto;
import com.portfolio.authservice.dto.user.UserLoginResponseDto;
import com.portfolio.authservice.dto.user.UserRegistrationRequestDto;
import com.portfolio.authservice.dto.user.UserResponseDto;
import com.portfolio.authservice.exception.RegistrationException;
import com.portfolio.authservice.service.AuthenticationService;

@Tag(name = "Authentication manager", description = "Endpoint for authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Register user", description = "User registration. You need to put user "
            + "as request body.")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "User login. You need to put user "
            + "as request body.")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
