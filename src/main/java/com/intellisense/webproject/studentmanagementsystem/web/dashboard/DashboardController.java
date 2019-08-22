package com.intellisense.webproject.studentmanagementsystem.web.dashboard;


import com.intellisense.webproject.studentmanagementsystem.user_mgnt.model.User;
import com.intellisense.webproject.studentmanagementsystem.user_mgnt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@RequestMapping
@Controller
public class DashboardController {

    private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
    //private final MessageSource messageSource;
    private UserService userService;
    //    @Autowired
//    public DashboardController(SettingService settingService, MessageSource messageSource, ApplicationUserService userService) {
//        this.settingService = settingService;
//        this.messageSource = messageSource;
//        this.userService = userService;
//    }

    @RequestMapping("/admin/dashboard")
    public String dashBoard() {
        logger.info("gottent to admin dashboard");
        return "dashboard/dashboard";
    }


    @RequestMapping("/")
    public String index() {

        return "redirect:/admin/dashboard";
    }

}
