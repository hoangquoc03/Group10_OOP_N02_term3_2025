package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Tenant;
import com.example.servingwebcontent.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TenantController {
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping("/tenants")
    public String showAllTenants(Model model) {
        List<Tenant> list = tenantService.getAllTenants();
        model.addAttribute("tenants", list);
        model.addAttribute("title", "Danh sách Người thuê");
        return "tenant_list"; // Tên file HTML
    }

    @GetMapping("/tenants/near-due")
    public String showTenantsNearDue(Model model) {
        List<Tenant> nearDueTenants = tenantService.getTenantsNearDueDate();
        model.addAttribute("tenants", nearDueTenants);
        model.addAttribute("title", "Người thuê gần đến hạn");
        return "tenant_list";
    }
}
