package com.intellisense.webproject.studentmanagementsystem.core.role_mgnt.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
