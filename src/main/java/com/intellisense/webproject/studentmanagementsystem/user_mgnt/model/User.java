package com.intellisense.webproject.studentmanagementsystem.user_mgnt.model;


import com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model.Roles;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable=false)
    @NotBlank(message = "* First Name is required")
    private String firstname;

    @Column(name="middlename", nullable=true)
    private String middlename;

    @Column(nullable=false)
    @NotBlank(message = "* Last Name is required")
    private String lastname;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Username is required")
    private String username;

    @Column(nullable=false, unique=true)
    @NotBlank(message = "* Email is required")
    @Email(message="{errors.invalid_email}")
    private String email;

    @Column(nullable=false)
    @NotBlank(message = "* Password is required")
    @Size(min=8)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    private Roles role;
    @Enumerated(EnumType.STRING)
    private UserType userType;


    private boolean enabled;
    private boolean tokenExpired;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", userType=" + userType +
                ", enabled=" + enabled +
                ", tokenExpired=" + tokenExpired +
                '}';
    }
}
