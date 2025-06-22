package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    // ✅ Sửa thành JPQL để Spring hiểu đúng LocalDateTime
    @Query("SELECT r FROM Room r WHERE r.dueDate IS NOT NULL AND r.dueDate BETWEEN :start AND :end")
    List<Room> findByDueDateBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
