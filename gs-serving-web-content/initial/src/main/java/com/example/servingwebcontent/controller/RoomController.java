package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.service.RoomService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    public RoomController() {
        this.roomService = new RoomService();
    }

    @GetMapping("/rooms")
    public String showRoomList(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "room_list"; // tên file room_list.html trong /resources/templates
    }
}
