package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.model.Notification;
import com.example.servingwebcontent.repository.FeedbackRepository;
import com.example.servingwebcontent.repository.InvoiceRepository;
import com.example.servingwebcontent.repository.NotificationRepository;
import com.example.servingwebcontent.repository.RoomRepository;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AdminStatsController {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final FeedbackRepository feedbackRepository;
    private final InvoiceRepository invoiceRepository;
    private final NotificationRepository notificationRepository;

    public AdminStatsController(
            UserRepository userRepository,
            RoomRepository roomRepository,
            FeedbackRepository feedbackRepository,
            InvoiceRepository invoiceRepository,
            NotificationRepository notificationRepository
    ) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.feedbackRepository = feedbackRepository;
        this.invoiceRepository = invoiceRepository;
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        try {
            Map<String, Long> stats = new HashMap<>();
            stats.put("admin", userRepository.countByRole(User.Role.admin));
            stats.put("landlord", userRepository.countByRole(User.Role.landlord));
            stats.put("tenant", userRepository.countByRole(User.Role.tenant));
            stats.put("occupiedRoom", roomRepository.countByStatus(Room.Status.occupied));
            stats.put("feedback", feedbackRepository.count());
            stats.put("invoice", invoiceRepository.count());
            stats.put("notification", notificationRepository.count());

            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi khi lấy thống kê: " + e.getMessage());
        }
    }

    @GetMapping("/notifications")
    public ResponseEntity<?> getNotifications() {
        try {
            // Trả về danh sách thông báo mới nhất (sắp xếp giảm dần theo createdAt)
            List<Notification> notifications = notificationRepository.findAll(
                    Sort.by(Sort.Direction.DESC, "createdAt")
            );
            return ResponseEntity.ok(notifications);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi khi lấy thông báo: " + e.getMessage());
        }
    }

    @GetMapping("/ping")
    public String ping() {
        return "API hoạt động";
    }
    @GetMapping("/feedbacks")
    public ResponseEntity<?> getFeedbacks() {
        try {
            return ResponseEntity.ok(feedbackRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi khi lấy phản hồi: " + e.getMessage());
        }
    }

    @GetMapping("/invoices")
    public ResponseEntity<?> getInvoices() {
        try {
            return ResponseEntity.ok(invoiceRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Lỗi khi lấy hóa đơn: " + e.getMessage());
        }
    }
}
