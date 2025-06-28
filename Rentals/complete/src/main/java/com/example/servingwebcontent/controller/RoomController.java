package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Device;
import com.example.servingwebcontent.repository.DeviceRepository;
import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.service.RoomService;
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
    private final RoomService roomService;
    private final DeviceRepository deviceRepository;
    public RoomController(RoomRepository roomRepository, RoomService roomService, DeviceRepository deviceRepository) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
        this.deviceRepository = deviceRepository;
    }

    // Hiển thị danh sách tất cả phòng
    @GetMapping("/all")
    public String listRooms(Model model) {
        try {
            model.addAttribute("rooms", roomRepository.findAll());
            return "room_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể tải danh sách phòng: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị form thêm mới phòng
    @GetMapping("/new")
    public String showAddForm(Model model) {
        try {
            model.addAttribute("room", new Room());
            return "room_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể hiển thị form thêm phòng: " + e.getMessage());
            return "error";
        }
    }

    // Lưu thông tin phòng (thêm/sửa)
    @PostMapping("/save")
    public String saveRoom(@ModelAttribute Room room, Model model) {
        try {
            roomRepository.save(room);
            return "redirect:/rooms/all";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi lưu phòng: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị form sửa phòng theo ID
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            Room room = roomRepository.findById(id).orElse(null);
            if (room == null) {
                model.addAttribute("errorMessage", "Không tìm thấy phòng với ID: " + id);
                return "error";
            }
            model.addAttribute("room", room);
            return "room_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi tải thông tin phòng: " + e.getMessage());
            return "error";
        }
    }

    // Xoá phòng theo ID
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Integer id, Model model) {
        try {
            roomRepository.deleteById(id);
            return "redirect:/rooms/all";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi xoá phòng: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị danh sách phòng sắp đến hạn (due_date trong 7 ngày tới)
    @GetMapping("/due")
    public String showRoomsDueSoon(Model model) {
        try {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime in7Days = now.plusDays(7);
            List<Room> dueRooms = roomRepository.findByDueDateBetweenAndStatus(now, in7Days, Room.Status.occupied);
            model.addAttribute("dueRooms", dueRooms);
            return "room_due_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi tải danh sách phòng đến hạn: " + e.getMessage());
            return "error";
        }
    }
    @GetMapping("/view/{id}")
    public String viewRoomDetails(@PathVariable Integer id, Model model) {
        Room room = roomService.getRoomById(id);
        if (room == null) {
            model.addAttribute("errorMessage", "Không tìm thấy phòng với ID: " + id);
            return "error";
        }
        List<Device> devices = deviceRepository.findByRoomId(id);
        model.addAttribute("room", room);
        model.addAttribute("devices", devices);
        return "room_detail";
   }
    @GetMapping("/search")
public String searchRooms(@RequestParam(required = false) String keyword,
                          @RequestParam(required = false) Room.Status status,
                          Model model) {
    try {
        List<Room> rooms;

        if ((keyword == null || keyword.isEmpty()) && status == null) {
            rooms = roomRepository.findAll(); // Không có gì được nhập
        } else if (keyword != null && !keyword.isEmpty() && status != null) {
            rooms = roomRepository.findByRoomNumberContainingIgnoreCaseAndStatus(keyword, status);
        } else if (keyword != null && !keyword.isEmpty()) {
            rooms = roomRepository.findByRoomNumberContainingIgnoreCase(keyword);
        } else {
            rooms = roomRepository.findByStatus(status);
        }

        model.addAttribute("rooms", rooms);
        return "room_list";
    } catch (Exception e) {
        model.addAttribute("errorMessage", "Lỗi khi tìm kiếm phòng: " + e.getMessage());
        return "error";
    }
}

}
