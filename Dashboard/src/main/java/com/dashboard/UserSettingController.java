package com.dashboard;

import java.sql.*;
import jakarta.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;

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
public class UserSettingController
{
    @GetMapping("/profile")
    public String UserProfile(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Profile");

//        String username = (String) session.getAttribute("username");
//
//        try {
//
//            Connection con = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/dashboard",
//                    "postgres",
//                    "12345"
//            );
//
//            String query = "SELECT * FROM users WHERE username=?";
//
//            PreparedStatement ps = con.prepareStatement(query);
//
//            ps.setString(1, username);
//
//            ResultSet rs = ps.executeQuery();
//
//            if(rs.next())
//            {
//                model.addAttribute("username", rs.getString("username"));
//                model.addAttribute("first_name", rs.getString("first_name"));
//                model.addAttribute("last_name", rs.getString("last_name"));
//                model.addAttribute("email", rs.getString("email"));
//                model.addAttribute("user_role", rs.getString("user_role"));
//                model.addAttribute("profile_picture", rs.getString("profile_picture"));
//            }
//
//        }
//
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }

        return "Dashboard/User/profile";
    }

//    @PostMapping("/profile")
//    public String UserUpdateProfile(HttpSession session,
//                                @RequestParam String first_name,
//                                @RequestParam String last_name,
//                                @RequestParam String email,
//                                    @RequestParam("profilePicture") MultipartFile file)
//    {
//        if(session.getAttribute("username") == null)
//        {
//            return "redirect:/login";
//        }
//
//        String username = (String) session.getAttribute("username");
//
//        try {
//
//            Connection con = DriverManager.getConnection(
//                    "jdbc:postgresql://localhost:5432/dashboard",
//                    "postgres",
//                    "12345"
//            );
//
//            String filename = null;
//
//            // Get existing profile picture
//            String currentQuery =
//                    "SELECT profile_picture FROM users WHERE username=?";
//
//            PreparedStatement currentPs =
//                    con.prepareStatement(currentQuery);
//
//            currentPs.setString(1, username);
//
//            ResultSet currentRs =
//                    currentPs.executeQuery();
//
//            if(currentRs.next())
//            {
//                filename = currentRs.getString("profile_picture");
//            }
//
//            // Upload Image
//            if(!file.isEmpty())
//            {
//                filename = System.currentTimeMillis()
//                        + "_"
//                        + file.getOriginalFilename();
//
//                Path uploadPath = Paths.get(
//                        "src/main/resources/static/uploads/profile"
//                );
//
//                if (!Files.exists(uploadPath)) {
//                    Files.createDirectories(uploadPath);
//                }
//
//                Files.copy(
//                        file.getInputStream(),
//                        uploadPath.resolve(filename),
//                        StandardCopyOption.REPLACE_EXISTING
//                );
//
////                System.out.println(file.getOriginalFilename());
//            }
//
//            String query = """
//                UPDATE users
//                SET first_name='Tarantej',
//                    last_name='Singh',
//                    email='tarantejsingh@gmail.com',
//                    profile_picture=?
//                WHERE username='Admin'
//                """;
//
//            PreparedStatement ps = con.prepareStatement(query);
//
//            ps.setString(1, filename);
//            ps.setString(2, username);
//
//            ps.setString(3, first_name);
//            ps.setString(4, last_name);
//            ps.setString(5, email);
//
//            ps.executeUpdate();
//
//        }
//
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//
//        return "redirect:/profile";
//    }
//
    @GetMapping("/account-settings")
    public String UserAccountSettings(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Account Settings");

        return "Dashboard/User/account-settings";
    }

    @GetMapping("/system-settings")
    public String UserSystemSettings(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "System Settings");

        return "Dashboard/User/system-settings";
    }

    @GetMapping("/activity-log")
    public String UserActivityLog(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Activity Log");

        return "Dashboard/User/activity-log";
    }

    @GetMapping("/notifications")
    public String UserNotifications(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Notifications");

        return "Dashboard/User/notifications";
    }

    @GetMapping("/messages")
    public String UserMessages(Authentication authentication, Model model)
    {
        //  Get Session Username
        model.addAttribute(
                "username",
                authentication.getName()
        );

        //  Breadcrumbs

        model.addAttribute("pageTitle", "Messages");

        return "Dashboard/User/messages";
    }

}