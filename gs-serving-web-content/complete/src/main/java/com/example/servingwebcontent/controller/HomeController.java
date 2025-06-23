package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToAdminDashboard() {
        return "redirect:/admin/admin_dashboard.html"; // chuyển hướng sang /admin
    }
}
