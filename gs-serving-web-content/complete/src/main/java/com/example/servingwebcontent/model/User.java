package com.example.servingwebcontent.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "landlord_id")
    private Integer landlordId;

    @Column(name = "tenant_id")
    private Integer tenantId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public enum Role {
        admin, landlord, tenant
    }

    // Getters + Setters...
}
