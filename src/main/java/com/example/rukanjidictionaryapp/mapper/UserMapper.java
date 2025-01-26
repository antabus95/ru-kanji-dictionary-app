package com.example.rukanjidictionaryapp.mapper;

import com.example.rukanjidictionaryapp.dto.UserDto;
import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserDto>{

    private final UserService userService;

    @Override
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        return userDto;
    }

    @Override
    public User toEntity(UserDto userDto) {
        User user = userService.getByUsername(userDto.getUsername());
        user.setRole(userDto.getRole());
        return user;
    }
}
