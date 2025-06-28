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
    private LocalDateTime createdAt = LocalDateTime.now(); // ✅ khởi tạo mặc định

    public enum Role {
        admin, landlord, tenant
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public Integer getLandlordId() { return landlordId; }
    public void setLandlordId(Integer landlordId) { this.landlordId = landlordId; }

    public Integer getTenantId() { return tenantId; }
    public void setTenantId(Integer tenantId) { this.tenantId = tenantId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
