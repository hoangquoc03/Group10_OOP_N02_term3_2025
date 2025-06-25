package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getVacantRooms() {
        return roomRepository.findByStatus(Room.Status.available);
    }

   
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
