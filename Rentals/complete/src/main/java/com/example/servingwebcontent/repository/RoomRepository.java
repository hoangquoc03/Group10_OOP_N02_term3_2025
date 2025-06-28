package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {


    List<Room> findByDueDateBetween(LocalDateTime start, LocalDateTime end);
    List<Room> findByDueDateBetweenAndStatus(LocalDateTime start, LocalDateTime end, Room.Status status);


    List<Room> findByStatus(Room.Status status);
    long countByStatus(Room.Status status);


    List<Room> findByRoomNumberContainingIgnoreCase(String keyword);

    List<Room> findByRoomNumberContainingIgnoreCaseAndStatus(String keyword, Room.Status status);
}
