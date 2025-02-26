package com.portfolio.taskmanagementapp.mapper;

import com.portfolio.taskmanagementapp.config.MapperConfig;
import com.portfolio.taskmanagementapp.dto.user.UserRegistrationRequestDto;
import com.portfolio.taskmanagementapp.dto.user.UserResponseDto;
import com.portfolio.taskmanagementapp.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface UserMapper {
    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto toDto(User user);
}
