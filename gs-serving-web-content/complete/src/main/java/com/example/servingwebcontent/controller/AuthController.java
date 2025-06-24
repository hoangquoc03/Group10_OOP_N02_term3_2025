package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // === Trang đăng ký ===
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "login_sign"; // form đăng ký ở templates/login_sign.html
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "Tên đăng nhập đã tồn tại.");
            return "login_sign";
        }

        user.setCreatedAt(LocalDateTime.now());
        userService.saveUser(user);
        return "redirect:/login";
    }

    // === Trang đăng nhập ===
    @GetMapping("/login")
    public String showLoginForm() {
        return "logn_in"; // form đăng nhập ở templates/logn_in.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        User user = userService.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu.");
            return "logn_in";
        }

        session.setAttribute("loggedInUser", user);

        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin"; // admin_dashboard.html nằm ở static/admin
        } else {
            return "redirect:/home"; // user_home.html nằm trong templates
        }
    }

    // === Đăng xuất ===
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
