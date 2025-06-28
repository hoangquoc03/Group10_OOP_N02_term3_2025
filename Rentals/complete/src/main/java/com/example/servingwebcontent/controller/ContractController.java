package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Contract;
import com.example.servingwebcontent.service.ContractService;
import com.example.servingwebcontent.service.RoomService;
import com.example.servingwebcontent.service.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;
    private final RoomService roomService;
    private final TenantService tenantService;

    public ContractController(ContractService contractService, RoomService roomService, TenantService tenantService) {
        this.contractService = contractService;
        this.roomService = roomService;
        this.tenantService = tenantService;
    }

    @GetMapping
    public String listContracts(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "admin_contracts";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("rooms", roomService.findAll());
        model.addAttribute("tenants", tenantService.findAll());
        return "contract_form";
    }

    @PostMapping("/save")
    public String saveContract(@ModelAttribute("contract") Contract contract) {
        contractService.save(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editContract(@PathVariable Long id, Model model) {
        Contract contract = contractService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contract ID: " + id));
        model.addAttribute("contract", contract);
        model.addAttribute("rooms", roomService.findAll());
        model.addAttribute("tenants", tenantService.findAll());
        return "contract_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteById(id);
        return "redirect:/contracts";
    }
    @PostMapping("/update/{id}")
    public String updateContract(@PathVariable Long id, @ModelAttribute("contract") Contract contract) {
        contract.setId(id); // gán lại ID cho chắc chắn
        contractService.save(contract); // dùng cùng 1 save() để lưu lại
        return "redirect:/contracts";
    }
}
