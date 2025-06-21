package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms/due")
    public String getRoomsNearDueDate(Model model) {
        LocalDate sevenDaysFromNow = LocalDate.now().plusDays(7);
        List<Room> rooms = roomRepository.findByDueDateBefore(sevenDaysFromNow);
        model.addAttribute("rooms", rooms);
        return "room_list";
    }

}
