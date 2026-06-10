package com.dashboard;

import java.sql.*;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public String UserProfile(HttpSession session, Model model)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        String username = (String) session.getAttribute("username");

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dashboard",
                    "postgres",
                    "12345"
            );

            String query = "SELECT * FROM users WHERE username=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                model.addAttribute("username", rs.getString("username"));
                model.addAttribute("first_name", rs.getString("first_name"));
                model.addAttribute("last_name", rs.getString("last_name"));
                model.addAttribute("email", rs.getString("email"));
                model.addAttribute("user_role", rs.getString("user_role"));
                model.addAttribute("profile_picture", rs.getString("profile_picture"));
            }

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return "Dashboard/profile";
    }

    @PostMapping("/profile")
    public String UserUpdateProfile(HttpSession session,
//                                @RequestParam String first_name,
//                                @RequestParam String last_name,
//                                @RequestParam String email,
                                @RequestParam("profilePicture") MultipartFile file)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        String username = (String) session.getAttribute("username");

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dashboard",
                    "postgres",
                    "12345"
            );

            String filename = null;

            // Get existing profile picture
            String currentQuery =
                    "SELECT profile_picture FROM users WHERE username=?";

            PreparedStatement currentPs =
                    con.prepareStatement(currentQuery);

            currentPs.setString(1, username);

            ResultSet currentRs =
                    currentPs.executeQuery();

            if(currentRs.next())
            {
                filename = currentRs.getString("profile_picture");
            }

            // Upload Image
            if(!file.isEmpty())
            {
                filename = System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

                Path uploadPath = Paths.get(
                        "src/main/resources/static/uploads/profile"
                );

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Files.copy(
                        file.getInputStream(),
                        uploadPath.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING
                );

//                System.out.println(file.getOriginalFilename());
            }

            String query = """
                UPDATE users
                SET first_name='Tarantej',
                    last_name='Singh',
                    email='tarantejsingh@gmail.com',
                    profile_picture=?
                WHERE username='Admin'
                """;

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, filename);
            ps.setString(2, username);

//            ps.setString(3, first_name);
//            ps.setString(4, last_name);
//            ps.setString(5, email);
            
            ps.executeUpdate();

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }


        return "redirect:/profile";
    }

    @GetMapping("/account-settings")
    public String UserAccountSettings(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/account-settings";
    }

    @GetMapping("/system-settings")
    public String UserSystemSettings(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/system-settings";
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

    @GetMapping("/activity-log")
    public String UserActivityLog(HttpSession session)
    {
        if(session.getAttribute("username") == null)
        {
            return "redirect:/login";
        }

        return "Dashboard/activity-log";
    }
}