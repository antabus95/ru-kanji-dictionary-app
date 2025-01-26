package com.example.rukanjidictionaryapp.service.impl;

import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.model.UserRole;
import com.example.rukanjidictionaryapp.repository.UserRepository;
import com.example.rukanjidictionaryapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("User with this username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }

        return save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public UserDetailsService getUserDetailsService() {
        return this::getByUsername;
    }

    @Override
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }


    @Override
    public void getAdmin(String username) {
        var user = getByUsername(username);
        /*
        List<UserRole> userRoles = user.getRoles();
        userRoles.add(UserRole.ROLE_ADMIN);
        user.setRoles(userRoles);
         */
        user.setRole(UserRole.ROLE_ADMIN);
        save(user);
    }

    @Override
    public void getEditor(String username) {
        var user = getByUsername(username);
        /*
        List<UserRole> userRoles = user.getRoles();
        userRoles.add(UserRole.ROLE_EDITOR);
        user.setRoles(userRoles);
         */
        user.setRole(UserRole.ROLE_EDITOR);
        save(user);
    }
}
