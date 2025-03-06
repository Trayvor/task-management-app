package com.portfolio.authservice.mapper;

import org.mapstruct.Mapper;
import com.portfolio.authservice.config.MapperConfig;
import com.portfolio.authservice.dto.user.UserRegistrationRequestDto;
import com.portfolio.authservice.dto.user.UserResponseDto;
import com.portfolio.authservice.model.User;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface UserMapper {
    User toModel(UserRegistrationRequestDto userRegistrationRequestDto);

    UserResponseDto toDto(User user);

}
