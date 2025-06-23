package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user_list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
