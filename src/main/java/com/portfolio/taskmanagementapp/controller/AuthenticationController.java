package com.portfolio.taskmanagementapp.controller;

import com.portfolio.taskmanagementapp.dto.user.UserLoginRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserLoginResponseDto;
import com.portfolio.taskmanagementapp.dto.user.UserRegistrationRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserResponseDto;
import com.portfolio.taskmanagementapp.exception.RegistrationException;
import com.portfolio.taskmanagementapp.service.AuthenticationService;
import com.portfolio.taskmanagementapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication manager", description = "Endpoint for authentication")
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Register user", description = "User registration. You need to put user "
            + "as request body.")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user", description = "User login. You need to put user "
            + "as request body.")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
