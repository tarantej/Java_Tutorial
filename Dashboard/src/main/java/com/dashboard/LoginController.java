package com.dashboard;

import java.sql.*;
import java.util.Optional;
import java.util.UUID;

import com.dashboard.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dashboard.service.MailService;

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

    // OAuth

    @GetMapping("/oauth-signup")
    public String OAuthSignupPage(Model model, Authentication authentication)
    {
        if (authentication == null) {
            return "redirect:/login";
        }

        if (!(authentication.getPrincipal() instanceof OAuth2User oauthUser)) {
            return "redirect:/login";
        }

        model.addAttribute("name", oauthUser.getAttribute("name"));
        model.addAttribute("email", oauthUser.getAttribute("email"));
        model.addAttribute("picture", oauthUser.getAttribute("picture"));

        return "Login/OAuth/oauth-signup";
    }

    @GetMapping("/oauth-success")
    public String OAuthSuccessPage(Model model)
    {
        //  Breadcrumbs

        model.addAttribute("pageTitle", "Success");
        return "Login/OAuth/oauth-success";
    }

    // Forgot Password

    @GetMapping("/forgot-password")
    public String forgotPassword()
    {
        return "Login/forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(
            @RequestParam String email,
            Model model)

    {
        Optional<DashboardUsers> user= userRepository.findByEmail(email);
        if(user.isPresent())
        {
            System.out.println("User found: " + user.get().getUsername());
            String token = UUID.randomUUID().toString();

            Timestamp expiry =
                    new Timestamp(System.currentTimeMillis()
                            + (15 * 60 * 1000));

            user.get().setResetToken(token);
            user.get().setResetTokenExpiry(expiry);

            userRepository.save(user.get());

            String resetLink = "http://localhost:8800/reset-password?token=" + token;

            mailService.sendResetEmail(email, resetLink);

            System.out.println(resetLink);
        }
        else
        {
            System.out.println("No User exists with email: " + email);
        }

        model.addAttribute("email", email);

        return "Login/success";

    }

    @Autowired
    private MailService mailService;



    // Reset Password

    @GetMapping("/reset-password")
    public String resetPassword
            (
            @RequestParam String token,
            Model model
    )
    {
        Optional<DashboardUsers> user =
                userRepository.findByResetToken(token);



        if(user.isEmpty())
        {
            model.addAttribute(
                    "error",
                    "Invalid password reset link.");

            return "Login/forgot-password";
        }

        Timestamp now =
                new Timestamp(System.currentTimeMillis());

        if(user.get().getResetTokenExpiry().before(now))
        {
            model.addAttribute(
                    "error",
                    "Password reset link has expired.");

            return "Login/forgot-password";
        }

                DashboardUsers resetUser = user.get();

        model.addAttribute("first_name", resetUser.getFirstName());
        model.addAttribute("last_name", resetUser.getLastName());
        model.addAttribute("token", token);


        return "Login/reset-password";
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/reset-password")
    public String processResetPassword(
            @RequestParam String token,
            @RequestParam String NewPassword,
            @RequestParam String confirmPassword,
            Model model
    )
    {
        Optional<DashboardUsers> user =
                userRepository.findByResetToken(token);

        if(user.isEmpty())
        {
            model.addAttribute(
                    "error",
                    "Invalid password reset link.");

            return "Login/forgot-password";
        }

        Timestamp now =
                new Timestamp(System.currentTimeMillis());

        if(user.get().getResetTokenExpiry().before(now))
        {
            model.addAttribute(
                    "error",
                    "Password reset link has expired.");

            return "Login/forgot-password";
        }

        if(!NewPassword.equals(confirmPassword))
        {
            model.addAttribute(
                    "error",
                    "Passwords do not match.");

            return "Login/reset-password";
        }

        DashboardUsers resetUser = user.get();

        resetUser.setPassword(
                passwordEncoder.encode(NewPassword)
        );

        resetUser.setResetToken(null);

        resetUser.setResetTokenExpiry(null);

        userRepository.save(resetUser);

        return "Login/reset-success";
    }

    //    Checking if User exists in database

//    @GetMapping("/test-user")
//    @ResponseBody
//    public String testUser() {
//
//        DashboardUsers user =
//                userRepository.findByUsername("SupAdmin")
//                        .orElse(null);
//
//        if (user == null) {
//            return "User not found";
//        }
//
//        return user.getUsername();
//    }
}
