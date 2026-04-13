package com.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/")
    public String home() {

        DashboardUsers u = new DashboardUsers("Tarantej", "Singh");

        return u.welcome();
    }
}
