package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("title", "Trang quản trị Admin");
        return "admin_dashboard"; // trỏ đến admin_dashboard.html trong templates
    }
}
