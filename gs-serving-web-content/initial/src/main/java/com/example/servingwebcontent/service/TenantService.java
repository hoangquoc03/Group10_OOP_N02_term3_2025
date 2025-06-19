package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Tenant;
import com.example.servingwebcontent.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;

        // Thêm dữ liệu mẫu nếu database trống
        if (tenantRepository.count() == 0) {
            Tenant t1 = new Tenant();
            t1.setName("Nguyen Thi D");
            t1.setPhone("0987654321");
            tenantRepository.save(t1);

            Tenant t2 = new Tenant();
            t2.setName("Pham Van E");
            t2.setPhone("0971234567");
            tenantRepository.save(t2);

            Tenant t3 = new Tenant();
            t3.setName("Tran Thi F");
            t3.setPhone("0962345678");
            tenantRepository.save(t3);
        }
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    public List<Tenant> getTenantsNearDueDate() {
        // Logic giả định
        return tenantRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}
