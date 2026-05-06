package com.dashboard;

import java.sql.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/")
    public String home() throws Exception {

        //  Database Connection
        try
        {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/dashboard",
                    "postgres",
                    "12345"
            );


            return "Database Connected Successfully";
//        DashboardUsers u = new DashboardUsers("Tarantej", "Singh");
//
//        return u.welcome();
        }

        catch (Exception e)
        {
            return e.getMessage();
        }

    }
}