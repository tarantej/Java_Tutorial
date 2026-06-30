package com.dashboard;

import java.sql.*;
import java.time.LocalTime;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String home()
    {

        return "index";
    }


    //  Dashboard Page

    @GetMapping("/dashboard")
    public String Dashboard(Model model,
                            Authentication authentication)
    {
        //  Greeting based on time of the day

        LocalTime now = LocalTime.now();

        String greeting;

        if (now.getHour() < 12) {
            greeting = "Good Morning";
        }
        else if (now.getHour() < 17) {
            greeting = "Good Afternoon";
        }
        else {
            greeting = "Good Evening";
        }

        model.addAttribute("greeting", greeting);

        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        return "Dashboard/dashboard";
    }


    @GetMapping("/blank")
    public String BlankPage(Model model, Authentication authentication)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Blank Page");
        
        return "Dashboard/blank";
    }


}