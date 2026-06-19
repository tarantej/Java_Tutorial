package com.dashboard;

import java.sql.*;


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
    public String Dashboard()
    {

        return "Dashboard/dashboard";
    }


    @GetMapping("/blank")
    public String BlankPage(Model model)
    {

        model.addAttribute("pageTitle", "Blank Page");
        
        return "Dashboard/blank";
    }


}