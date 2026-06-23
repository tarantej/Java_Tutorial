package com.dashboard;

import java.sql.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LoginController
{
    //    Login

    @GetMapping("/login")
    public String loginPage()
    {

        return"Login/login";
    }

    // Logout

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();

        return "redirect:/login";
    }

    // Register

    @GetMapping("/register")
    public String userRegister()
    {
        return "Login/register";
    }

    // Forgot Password

    @GetMapping("/forgot-password")
    public String forgotPassword()
    {
        return "Login/forgot-password";
    }

    // Reset Password

    @GetMapping("/reset-password")
    public String resetPassword()
    {
        return "Login/reset-password";
    }

    //    Checking if User exists in database

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test-user")
    @ResponseBody
    public String testUser() {

        DashboardUsers user =
                userRepository.findByUsername("SupAdmin")
                        .orElse(null);

        if (user == null) {
            return "User not found";
        }

        return user.getUsername();
    }
}