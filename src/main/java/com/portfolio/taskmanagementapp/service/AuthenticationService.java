package com.portfolio.taskmanagementapp.service;

import com.portfolio.taskmanagementapp.dto.user.UserLoginRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserLoginResponseDto;

public interface AuthenticationService {
    UserLoginResponseDto authenticate(UserLoginRequestDto userLoginRequestDto);
}
