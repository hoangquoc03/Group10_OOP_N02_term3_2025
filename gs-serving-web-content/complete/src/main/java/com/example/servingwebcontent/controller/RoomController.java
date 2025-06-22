package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    // ✅ Danh sách phòng sắp đến hạn thanh toán (trong 7 ngày tới)
    @GetMapping("/rooms/due")
    public String getRoomsNearDueDate(Model model) {
        // Tạo mốc thời gian từ 00:00 hôm nay đến 23:59:59 bảy ngày sau
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime end = start.plusDays(7).withHour(23).withMinute(59).withSecond(59).withNano(0);

        System.out.println(">>> [DEBUG] Searching rooms due between " + start + " and " + end);

        List<Room> rooms = roomRepository.findByDueDateBetween(start, end);

        System.out.println(">>> [DEBUG] Rooms found: " + rooms.size());
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomNumber() + ", Due Date: " + room.getDueDate());
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("count", rooms.size());
        return "room_list";
    }

    // ✅ Hiển thị toàn bộ phòng
    @GetMapping("/rooms/all")
    public String getAllRooms(Model model) {
        List<Room> rooms = roomRepository.findAll();

        System.out.println(">>> [DEBUG] Total rooms found: " + rooms.size());
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomNumber() + ", Due Date: " + room.getDueDate());
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("count", rooms.size());
        return "room_list";
    }
}
