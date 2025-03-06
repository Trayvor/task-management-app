package com.portfolio.authservice.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.portfolio.authservice.dto.user.UserLoginRequestDto;
import com.portfolio.authservice.dto.user.UserLoginResponseDto;
import com.portfolio.authservice.dto.user.UserRegistrationRequestDto;
import com.portfolio.authservice.dto.user.UserResponseDto;
import com.portfolio.authservice.mapper.UserMapper;
import com.portfolio.authservice.model.Role;
import com.portfolio.authservice.repository.RoleRepository;
import com.portfolio.authservice.repository.UserRepository;
import com.portfolio.authservice.security.JwtUtil;
import com.portfolio.authservice.service.AuthenticationService;
import com.portfolio.authservice.exception.RegistrationException;
import com.portfolio.authservice.model.User;
import com.portfolio.authservice.model.type.UserRole;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private Role userRole;

    @PostConstruct
    public void init() {
        userRole = roleRepository.findByRole(UserRole.ROLE_USER).orElseThrow(
                () -> new EntityNotFoundException("Can`t find role with name: "
                        + UserRole.ROLE_USER.name())
        );
    }

    @Override
    public UserLoginResponseDto authenticate(UserLoginRequestDto userLoginRequestDto) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginRequestDto.email(), userLoginRequestDto.password())
        );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }

    @Transactional
    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(requestDto.email())) {
            throw new RegistrationException("Can`t register user. Account with email "
                    + requestDto.email() + " is already exists");
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
