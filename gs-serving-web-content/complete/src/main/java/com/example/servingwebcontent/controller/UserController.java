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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        try {
            model.addAttribute("users", userService.getAllUsers());
            return "user_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể tải danh sách người dùng: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        try {
            model.addAttribute("user", new User());
            return "user_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể hiển thị form: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user, Model model) {
        try {
            System.out.println("Saving user: " + user.getFullname());
            userService.saveUser(user);
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi lưu người dùng: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        try {
            User user = userService.getUserById(id);
            if (user == null) {
                model.addAttribute("errorMessage", "Không tìm thấy người dùng với ID: " + id);
                return "error";
            }
            model.addAttribute("user", user);
            return "user_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi chỉnh sửa người dùng: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            userService.deleteUser(id);
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi xóa người dùng: " + e.getMessage());
            return "error";
        }
    }
    // === Trang đăng ký ===
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "login_sign"; // file HTML chứa form đăng ký
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMessage", "Tên đăng nhập đã tồn tại.");
            return "login_sign";
        }

        user.setCreated_at(LocalDateTime.now());
        userService.saveUser(user);
        return "redirect:/login";
    }

    // === Trang đăng nhập ===
    @GetMapping("/login")
    public String showLoginForm() {
        return "logn_in"; // file HTML chứa form đăng nhập
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
            return "redirect:/admin";
        } else {
            return "redirect:/home"; // người dùng thường → có thể thay đổi
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
