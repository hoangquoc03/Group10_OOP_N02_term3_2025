package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.repository.RoomRepository;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.model.User; // 🟢 Import User để dùng User.Role
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminStatsController {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public AdminStatsController(UserRepository userRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        try {
            Map<String, Long> stats = new HashMap<>();
            stats.put("admin", userRepository.countByRole(User.Role.admin));       // ✅ dùng Enum thay vì String
            stats.put("landlord", userRepository.countByRole(User.Role.landlord));
            stats.put("tenant", userRepository.countByRole(User.Role.tenant));
            stats.put("occupiedRoom", roomRepository.countByStatus(Room.Status.occupied));
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi khi lấy thống kê: " + e.getMessage());
        }
    }

    @GetMapping("/ping")
    public String ping() {
        return "API hoạt động";
    }
}
