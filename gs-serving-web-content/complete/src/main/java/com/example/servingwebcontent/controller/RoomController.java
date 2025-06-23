package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Hiển thị danh sách tất cả phòng
    @GetMapping("/all")
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        return "room_list";
    }

    // Hiển thị form thêm mới phòng
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("room", new Room());
        return "room_form";
    }

    // Lưu thông tin phòng (thêm/sửa)
    @PostMapping("/save")
    public String saveRoom(@ModelAttribute Room room) {
        roomRepository.save(room);
        return "redirect:/rooms/all";
    }

    // Hiển thị form sửa phòng theo ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Room room = roomRepository.findById(id).orElse(new Room());
        model.addAttribute("room", room);
        return "room_form";
    }

    // Xoá phòng theo ID
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id) {
        roomRepository.deleteById(id);
        return "redirect:/rooms/all";
    }

    // Hiển thị danh sách phòng sắp đến hạn (due_date trong 7 ngày tới)
    @GetMapping("/due")
    public String showRoomsDueSoon(Model model) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime in7Days = now.plusDays(7);
        List<Room> dueRooms = roomRepository.findByDueDateBetweenAndStatus(now, in7Days, Room.Status.occupied);

        model.addAttribute("dueRooms", dueRooms);
        return "room_due_list";
    }
    

}
