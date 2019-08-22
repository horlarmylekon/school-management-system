package com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model;


import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.UserType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="role")
    private String name;
    private String email;
    private String description;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission", joinColumns =
    @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns =
    @JoinColumn(name = "permission_id", referencedColumnName = "id") )
    private Collection<Permissions> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Collection<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permissions> permissions) {
        this.permissions = permissions;
    }
}
