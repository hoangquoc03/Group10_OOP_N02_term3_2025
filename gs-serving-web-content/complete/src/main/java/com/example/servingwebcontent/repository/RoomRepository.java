package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByDueDateBefore(LocalDate date);
}
