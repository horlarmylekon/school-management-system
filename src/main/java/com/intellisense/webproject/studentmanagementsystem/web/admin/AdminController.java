package com.intellisense.webproject.studentmanagementsystem.web.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasAnyRole(ADMIN)")
    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }
}
