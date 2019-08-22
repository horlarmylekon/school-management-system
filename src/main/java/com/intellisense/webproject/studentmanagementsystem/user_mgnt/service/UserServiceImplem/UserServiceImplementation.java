package com.intellisense.webproject.studentmanagementsystem.user_mgnt.service.UserServiceImplem;

import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import com.intellisense.webproject.studentmanagementsystem.user_mgnt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Override
    public Optional<User> findByUsername(String name) {
        return Optional.empty();
    }
}
