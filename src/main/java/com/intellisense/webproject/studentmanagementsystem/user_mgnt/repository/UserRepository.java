package com.intellisense.webproject.studentmanagementsystem.user_mgnt.repository;


import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    User findByEmail(String email);
}
