package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tenantId;

    private String name;
    private String phone;
    private String identityCard;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    // Getters and Setters
}
