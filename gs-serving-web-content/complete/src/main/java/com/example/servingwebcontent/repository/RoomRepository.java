package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    // Truy vấn danh sách phòng có dueDate nằm trong khoảng từ now đến 7 ngày tới
    List<Room> findByDueDateBetween(LocalDateTime start, LocalDateTime end);
    List<Room> findByDueDateBetweenAndStatus(LocalDateTime start, LocalDateTime end, Room.Status status);
    long countByStatus(Room.Status status);
}
 