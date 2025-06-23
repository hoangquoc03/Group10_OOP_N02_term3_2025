package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String redirectToStaticAdminPage() {
        return "redirect:/admin/admin_dashboard.html"; // Chuyển hướng đến file trong static
    }
}
