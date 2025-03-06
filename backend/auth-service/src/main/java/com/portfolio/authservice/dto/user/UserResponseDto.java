package com.portfolio.authservice.dto.user;

import java.util.Set;
import com.portfolio.authservice.model.Role;

public record UserResponseDto(
        Long id,
        String email,
        String firstName,
        String lastName,
        String username,
        Set<Role> roles
) {
}
