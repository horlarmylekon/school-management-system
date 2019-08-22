package com.intellisense.webproject.studentmanagementsystem.core.security;


import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import com.intellisense.webproject.studentmanagementsystem.user_mgnt.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);
            logger.info("Username: " + optionalUser.get().getUsername());

            optionalUser
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

            return optionalUser.map(CustomUserDetails::new).get();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
