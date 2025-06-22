package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    // ✅ Danh sách phòng sắp đến hạn thanh toán (7 ngày tới)
    @GetMapping("/rooms/due")
    public String getRoomsNearDueDate(Model model) {
        LocalDateTime todayStart = LocalDate.now().atStartOfDay();
        LocalDateTime next7DaysEnd = todayStart.plusDays(7).withHour(23).withMinute(59).withSecond(59);

        System.out.println(">>> [DEBUG] Searching rooms from " + todayStart + " to " + next7DaysEnd);

        List<Room> rooms = roomRepository.findRoomsDueBetween(todayStart, next7DaysEnd);

        System.out.println(">>> [DEBUG] Rooms found: " + rooms.size());
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomNumber() + ", Due Date: " + room.getDueDate());
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("count", rooms.size());
        return "room_list";
    }

    // ✅ Danh sách tất cả các phòng
    @GetMapping("/rooms/all")
    public String getAllRooms(Model model) {
        List<Room> rooms = roomRepository.findAll();

        System.out.println(">>> [DEBUG] All rooms: " + rooms.size());
        for (Room room : rooms) {
            System.out.println("Room: " + room.getRoomNumber() + ", Due Date: " + room.getDueDate());
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("count", rooms.size());
        return "room_list";
    }
}
