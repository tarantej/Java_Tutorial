package com.dashboard;

import java.sql.*;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String Dashboard(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/dashboard";
    }


    @GetMapping("/blank")
    public String BlankPage(HttpSession session, Model model)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Blank Page");
        
        return "Dashboard/blank";
    }


}