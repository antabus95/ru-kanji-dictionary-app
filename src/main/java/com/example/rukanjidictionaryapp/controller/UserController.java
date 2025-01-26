package com.example.rukanjidictionaryapp.controller;

import com.example.rukanjidictionaryapp.dto.UserDto;
import com.example.rukanjidictionaryapp.mapper.Mapper;
import com.example.rukanjidictionaryapp.mapper.UserMapper;
import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/kanjidic/user-list")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Mapper<User, UserDto> userMapper;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.toDto(user));
        }
        return userDtos;
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@RequestBody UserDto userDto) {
        return userMapper.toEntity(userDto);
    }

}
