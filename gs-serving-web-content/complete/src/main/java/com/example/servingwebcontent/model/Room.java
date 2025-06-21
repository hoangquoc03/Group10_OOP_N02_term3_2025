package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomNumber;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    private LocalDate rentedFrom;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum RoomStatus {
        AVAILABLE, OCCUPIED, MAINTENANCE
    }

    // Getters and Setters
}
