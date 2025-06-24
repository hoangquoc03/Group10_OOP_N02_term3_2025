package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectBasedOnRole(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/users/login";

        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin/admin_dashboard.html"; // static file
        } else {
            return "redirect:/home"; // Thymeleaf template
        }
    }

    @GetMapping("/home")
    public String showUserHome() {
        return "user_home"; // templates/user_home.html
    }
}
