package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String redirectToStaticAdminPage() {
        // Chuyển hướng đến file HTML trong thư mục static
        return "admin_dashboard";
    }
}
