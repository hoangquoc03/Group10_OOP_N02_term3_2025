package com.example.servingwebcontent.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition", nullable = false)
    private Condition condition;

    @Column(name = "last_checked")
    private LocalDate lastChecked;

    public enum Condition {
        good, broken, maintenance
    }

    // Constructors
    public Device() {
    }

    public Device(Integer roomId, String name, Condition condition, LocalDate lastChecked) {
        this.roomId = roomId;
        this.name = name;
        this.condition = condition;
        this.lastChecked = lastChecked;
    }

    // Getters and Setters
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public LocalDate getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDate lastChecked) {
        this.lastChecked = lastChecked;
    }
}
