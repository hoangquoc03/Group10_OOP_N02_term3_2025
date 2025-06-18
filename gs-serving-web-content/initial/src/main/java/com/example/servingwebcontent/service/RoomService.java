package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    public RoomService() {
        rooms.add(new Room("R1", "Phòng A1", 1200000, "Nguyễn Văn A"));
        rooms.add(new Room("R2", "Phòng B2", 1500000, "Trần Thị B"));
        rooms.add(new Room("R3", "Phòng C3", 1800000, "Lê Văn C"));
    }

    public List<Room> findAll() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
