package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms/near-payment")
    public String showRoomsNearPayment(Model model) {
        List<Room> nearDueRooms = roomService.getRoomsNearPaymentDate();
        model.addAttribute("rooms", nearDueRooms);
        return "room_list"; // Sử dụng lại room_list.html để hiển thị
    }
}
