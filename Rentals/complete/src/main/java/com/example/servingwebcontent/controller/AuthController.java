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

    // === Trang hiển thị đăng nhập & đăng ký ===
    @GetMapping({"/login", "/register"})
    public String showLoginRegisterPage(Model model) {
        model.addAttribute("user", new User()); // đảm bảo có object để binding
        return "login_sign"; // chung một file form
    }

    // === Đăng ký ===
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "❌ Tên đăng nhập đã tồn tại.");
            return "login_sign";
        }

        user.setCreatedAt(LocalDateTime.now());
        userService.saveUser(user);
        model.addAttribute("successMessage", "✅ Đăng ký thành công! Hãy đăng nhập.");
        model.addAttribute("user", new User());
        return "login_sign"; // trở lại trang với thông báo
    }

    // === Đăng nhập ===
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        User user = userService.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("errorMessage", "❌ Sai tên đăng nhập hoặc mật khẩu.");
            model.addAttribute("user", new User());
            return "login_sign";
        }

        session.setAttribute("loggedInUser", user);

        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin"; // Giao diện admin
        } else {
            return "redirect:/home"; // Giao diện người dùng
        }
    }

    // === Đăng xuất ===
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("user", new User()); // cần cho Thymeleaf binding form
        return "login_sign"; // quay lại form login/register
    }
}
