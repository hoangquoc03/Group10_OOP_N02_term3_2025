package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Tenant;
import com.example.servingwebcontent.repository.TenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tenants")
public class TenantController {

    private final TenantRepository tenantRepository;

    public TenantController(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @GetMapping
    public String listTenants(Model model) {
        model.addAttribute("tenants", tenantRepository.findAll());
        return "tenant_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("tenant", new Tenant());
        return "tenant_form";
    }

    @PostMapping("/save")
    public String saveTenant(@ModelAttribute Tenant tenant) {
        tenantRepository.save(tenant);
        return "redirect:/tenants";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("tenant", tenantRepository.findById(id).orElse(null));
        return "tenant_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTenant(@PathVariable Integer id) {
        tenantRepository.deleteById(id);
        return "redirect:/tenants";
    }
}
