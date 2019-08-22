package com.intellisense.webproject.studentmanagementsystem.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {


    @GetMapping("/admin/login")
    public String showLoginPage(@RequestParam(value = "failed", required = false) boolean failed, Model model) {

        if (failed) {
            //if user credential is invalid return an invalid credential message
            // to the view.
            model.addAttribute("failed", true);
        }
        return "security/login";
    }

}
