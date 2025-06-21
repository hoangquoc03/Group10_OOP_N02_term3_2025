package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long landlordId;

    private String name;
    private String phone;
    private String address;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters
}
