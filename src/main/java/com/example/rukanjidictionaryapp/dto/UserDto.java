package com.example.rukanjidictionaryapp.dto;

import com.example.rukanjidictionaryapp.model.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String username;

    private UserRole role;

}
