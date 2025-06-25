package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.RoomService;
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

    @Autowired
    private RoomService roomService; 

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
    // Hiển thị thông tin người dùng
    @GetMapping("/edit-profile")
    public String showEditForm(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("loggedInUser");
        if (currentUser == null) return "redirect:/login";

        User user = userService.getUserById(currentUser.getId());
        model.addAttribute("user", user);
        return "User/edit_profile";
    }

    // Cập nhật thông tin
    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute("user") User updatedUser, HttpSession session) {
        User sessionUser = (User) session.getAttribute("loggedInUser");
        updatedUser.setId(sessionUser.getId()); 

        userService.saveUser(updatedUser);
        session.setAttribute("loggedInUser", updatedUser); 
        return "redirect:/home";
    }
    @GetMapping("/available-rooms")
    public String showRoomCards(Model model) {
        model.addAttribute("vacantRooms", roomService.getVacantRooms()); 
        return "User/room_cards"; 
    }
}
