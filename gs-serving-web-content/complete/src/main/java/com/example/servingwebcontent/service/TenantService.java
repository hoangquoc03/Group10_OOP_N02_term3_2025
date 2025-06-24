package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public long getTenantCount() {
        return tenantRepository.count();
    }
}
