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

//    Login

    @GetMapping("/login")
    public String loginPage()
    {

        return"Login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session,  Model model)
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

                session.setAttribute("username", userName);
                session.setAttribute("firstName", firstName);
                session.setAttribute("lastName", lastName);

                return "redirect:/dashboard";
            }

            else {

                model.addAttribute("error", "Invalid Username or Password");

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
    public String logout(HttpSession session)
    {
        session.invalidate();

        return "redirect:/login";
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

    @GetMapping("/profile")
    public String UserProfile(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/profile";
    }
    @GetMapping("/settings")
    public String UserSettings(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/settings";
    }
    @GetMapping("/blank")
    public String BlankPage(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }
        
        return "Dashboard/blank";
    }
}