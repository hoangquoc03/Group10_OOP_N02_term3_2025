package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    // Lấy danh sách thiết bị theo room_id
    List<Device> findByRoomId(Integer roomId);
}
