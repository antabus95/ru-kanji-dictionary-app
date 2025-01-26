package com.example.rukanjidictionaryapp.service;

import com.example.rukanjidictionaryapp.model.User;
import com.example.rukanjidictionaryapp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    User save(User user);

    User create(User user);

    List<User> getAllUsers();

    User getByUsername(String username);

    User getById(long id);

    UserDetailsService getUserDetailsService();

    User getCurrentUser();

    void getAdmin(String username);

    void getEditor(String username);

}
