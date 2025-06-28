package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    public RoomService() {
        rooms.add(new Room("R1", 1200000, "123 Trần Hưng Đạo", "Nguyễn Văn A", "Lê Thị B", "2025-06-19"));
        rooms.add(new Room("R2", 1500000, "456 Lý Thường Kiệt", "Trần Văn C", "Nguyễn Văn D", "2025-06-22"));
        rooms.add(new Room("R3", 1800000, "789 Nguyễn Trãi", "Hoàng Thị E", "Phạm Văn F", "2025-07-01"));
    }

    public List<Room> getRoomsNearPaymentDate() {
        List<Room> result = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (Room room : rooms) {
            try {
                LocalDate paymentDate = room.getPaymentDate(); // Đã là LocalDate, không cần parse
                long daysBetween = ChronoUnit.DAYS.between(today, paymentDate);
                if (daysBetween >= 0 && daysBetween <= 5) {
                    result.add(room);
                }
            } catch (Exception e) {
                System.err.println("Lỗi xử lý ngày cho phòng: " + room.getId());
            }
        }

        return result;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
