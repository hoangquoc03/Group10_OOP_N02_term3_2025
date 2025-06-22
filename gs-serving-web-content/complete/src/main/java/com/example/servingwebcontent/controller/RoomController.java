package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms/due")
    public String getRoomsNearDueDate(Model model) {
        LocalDateTime now = LocalDate.now().atStartOfDay(); // 💡 Đảm bảo từ 00:00 hôm nay
        LocalDateTime sevenDaysFromNow = now.plusDays(7);
        List<Room> rooms = roomRepository.findByDueDateBetween(now, sevenDaysFromNow);
        model.addAttribute("rooms", rooms);
        return "room_list";
    }

    @GetMapping("/rooms/all")
    public String getAllRooms(Model model) {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "room_list";
    }
}
