package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Tenant;
import com.example.servingwebcontent.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping
    public String listTenants(Model model) {
        List<Tenant> tenants = tenantRepository.findAll();
        model.addAttribute("tenants", tenants);
        return "tenant_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tenant", new Tenant());
        return "tenant_form";
    }

    @PostMapping("/save")
    public String saveTenant(@ModelAttribute Tenant tenant) {
        tenantRepository.save(tenant);
        return "redirect:/tenants";
    }

    @GetMapping("/edit/{id}")
    public String editTenant(@PathVariable Long id, Model model) {
        Tenant tenant = tenantRepository.findById(id).orElseThrow();
        model.addAttribute("tenant", tenant);
        return "tenant_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTenant(@PathVariable Long id) {
        tenantRepository.deleteById(id);
        return "redirect:/tenants";
    }
}
