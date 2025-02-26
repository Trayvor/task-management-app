package com.portfolio.taskmanagementapp.service;

import com.portfolio.taskmanagementapp.dto.user.UserRegistrationRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserResponseDto;
import com.portfolio.taskmanagementapp.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}
