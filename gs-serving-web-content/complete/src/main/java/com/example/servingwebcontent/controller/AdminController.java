// AdminStatsController.java
package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.repository.RoomRepository;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.model.Room;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("admin", userRepository.countByRole("admin"));
        stats.put("landlord", userRepository.countByRole("landlord"));
        stats.put("tenant", userRepository.countByRole("tenant"));
        stats.put("occupiedRoom", roomRepository.countByStatus(Room.Status.occupied));
        return stats;
    }
}
