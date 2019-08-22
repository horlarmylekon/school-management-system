package com.intellisense.webproject.studentmanagementsystem.core.security;

import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

    private User user;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomUserDetails(final User user ) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        logger.info("initializing available roles with corresponding permissions");

        final List<GrantedAuthority> authorities = new ArrayList<>();

        user.getRole().getPermissions().forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
