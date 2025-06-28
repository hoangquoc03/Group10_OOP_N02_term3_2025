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

    // === Trang đăng nhập & đăng ký (sử dụng chung 1 trang login_sign.html) ===
    @GetMapping({"/login", "/register"})
    public String showLoginRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "login_sign";
    }

    // === Xử lý đăng ký ===
    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "❌ Tên đăng nhập đã tồn tại.");
            return "login_sign";
        }

        user.setCreatedAt(LocalDateTime.now());
        userService.saveUser(user);
        model.addAttribute("successMessage", "✅ Đăng ký thành công! Vui lòng đăng nhập.");
        model.addAttribute("user", new User()); // reset form
        return "login_sign";
    }

    // === Xử lý đăng nhập ===
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        System.out.println("🔐 Đăng nhập với: " + username);
        User user = userService.getUserByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("❌ Sai thông tin đăng nhập.");
            model.addAttribute("errorMessage", "❌ Sai tên đăng nhập hoặc mật khẩu.");
            model.addAttribute("user", new User());
            return "login_sign";
        }

        session.setAttribute("loggedInUser", user);
        System.out.println("✅ Đăng nhập thành công: " + user.getUsername() + " - Vai trò: " + user.getRole());

        // Phân quyền điều hướng
        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin";
        } else {
            return "redirect:/home";
        }
    }

    // === Đăng xuất ===
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("user", new User());
        return "login_sign";
    }
}
