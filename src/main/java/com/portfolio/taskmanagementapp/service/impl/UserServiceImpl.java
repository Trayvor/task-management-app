package com.portfolio.taskmanagementapp.service.impl;

import com.portfolio.taskmanagementapp.dto.user.UserRegistrationRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserResponseDto;
import com.portfolio.taskmanagementapp.exception.RegistrationException;
import com.portfolio.taskmanagementapp.mapper.UserMapper;
import com.portfolio.taskmanagementapp.model.Role;
import com.portfolio.taskmanagementapp.model.User;
import com.portfolio.taskmanagementapp.model.type.UserRole;
import com.portfolio.taskmanagementapp.repository.RoleRepository;
import com.portfolio.taskmanagementapp.repository.UserRepository;
import com.portfolio.taskmanagementapp.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    private Role userRole;

    @PostConstruct
    public void init() {
        userRole = roleRepository.findByRole(UserRole.ROLE_USER).orElseThrow(
                () -> new EntityNotFoundException("Can`t find role with name: "
                        + UserRole.ROLE_USER.name())
        );
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
