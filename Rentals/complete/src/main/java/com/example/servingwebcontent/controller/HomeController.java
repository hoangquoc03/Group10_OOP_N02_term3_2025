package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/")
    public String redirectBasedOnRole(HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        if (user.getRole() == User.Role.admin) {
            return "redirect:/admin/admin_dashboard.html";
        } else {
            return "redirect:/home";
        }
    }

    @GetMapping("/home")
    public String showUserHome(Model model) {
        List<Room> availableRooms = roomRepository.findByStatus(Room.Status.available); // Thêm dòng này
        model.addAttribute("rooms", availableRooms); // Truyền danh sách phòng trống
        return "user_home";
    }
}
