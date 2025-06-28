package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    long count();
}
