package com.intellisense.webproject.studentmanagementsystem.user_mgnt.service;

import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService{
    Optional<User> findByUsername(String name);
}
