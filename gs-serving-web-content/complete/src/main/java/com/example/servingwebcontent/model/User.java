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

    private Integer landlord_id;
    private Integer tenant_id;

    private LocalDateTime created_at;

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

    public Integer getLandlord_id() { return landlord_id; }
    public void setLandlord_id(Integer landlord_id) { this.landlord_id = landlord_id; }

    public Integer getTenant_id() { return tenant_id; }
    public void setTenant_id(Integer tenant_id) { this.tenant_id = tenant_id; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}
