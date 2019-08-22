package com.intellisense.webproject.studentmanagementsystem.user_mgnt.model;

import java.util.Arrays;
import java.util.List;

public enum UserType {
    ADMIN("ADMIN"),
    TEACHER("TEACHER"),
    STUDENT("STUDENT");

    private String description;

    UserType(String description){
        this.description = description;
    }

    public static List<UserType> getUseryTypes(){
        return Arrays.asList(UserType.values());
    }

}
