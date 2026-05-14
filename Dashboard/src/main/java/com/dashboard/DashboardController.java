package com.dashboard;

import java.sql.*;

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

//    Login

    @GetMapping("/login")
    public String loginPage()
    {

        return"login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model)
    {
        // Login Validation

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dashboard",
                    "postgres",
                    "12345"
            );

            String query = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String userName = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                model.addAttribute(
                        "username",userName
                );

                return "Dashboard/dashboard";
            }

            else {

                model.addAttribute(
                        "error",
                        "Invalid Username or Password"
                );

                return "Login/login";
            }

        }

        catch(Exception e) {

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Database Error"
            );

            return "Login/login";
        }
    }

    // Logout

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/login";
    }

    //  Dashboard Page

    @GetMapping("/dashboard")
    public String Dashboard()
    {
        System.out.println("Welcome to the Dashboard");
        return "Dashboard/dashboard";
    }
}