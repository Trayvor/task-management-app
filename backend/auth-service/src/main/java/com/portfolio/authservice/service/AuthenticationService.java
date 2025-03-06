package com.portfolio.authservice.service;

import com.portfolio.authservice.dto.user.UserRegistrationRequestDto;
import com.portfolio.authservice.dto.user.UserResponseDto;
import com.portfolio.authservice.dto.user.UserLoginRequestDto;
import com.portfolio.authservice.dto.user.UserLoginResponseDto;
import com.portfolio.authservice.exception.RegistrationException;

public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto userLoginRequestDto);

    UserResponseDto register(UserRegistrationRequestDto userRegistrationRequestDto) throws RegistrationException;
}
