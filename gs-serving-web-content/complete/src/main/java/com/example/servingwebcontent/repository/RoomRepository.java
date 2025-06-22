package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    // ✅ Native query dùng BETWEEN thời gian
    @Query(value = "SELECT * FROM rooms WHERE due_date IS NOT NULL AND due_date BETWEEN :start AND :end", nativeQuery = true)
    List<Room> findByDueDateBetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
