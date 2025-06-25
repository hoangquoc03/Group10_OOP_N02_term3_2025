package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Tenant;
import com.example.servingwebcontent.repository.TenantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.servingwebcontent.model.Room;
import com.example.servingwebcontent.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Controller
@RequestMapping("/tenants")
public class TenantController {

    private final TenantRepository tenantRepository;
    @Autowired
    private RoomService roomService; 

    public TenantController(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @GetMapping
    public String listTenants(Model model) {
        try {
            model.addAttribute("tenants", tenantRepository.findAll());
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải danh sách người thuê: " + e.getMessage());
        }
        return "tenant_list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        try {
            model.addAttribute("tenant", new Tenant());
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tạo form thêm mới: " + e.getMessage());
        }
        return "tenant_form";
    }

    @PostMapping("/save")
    public String saveTenant(@ModelAttribute Tenant tenant, Model model) {
        try {
            tenantRepository.save(tenant);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu người thuê: " + e.getMessage());
            return "tenant_form";
        }
        return "redirect:/tenants";
    }

    @GetMapping("/add")
    public String redirectToAdd() {
        return "redirect:/tenants/new";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        try {
            Tenant tenant = tenantRepository.findById(id).orElse(null);
            if (tenant == null) {
                model.addAttribute("error", "Không tìm thấy người thuê.");
                return "redirect:/tenants";
            }
            model.addAttribute("tenant", tenant);
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tải thông tin người thuê: " + e.getMessage());
            return "redirect:/tenants";
        }
        return "tenant_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTenant(@PathVariable Integer id, Model model) {
        try {
            if (tenantRepository.existsById(id)) {
                tenantRepository.deleteById(id);
            } else {
                model.addAttribute("error", "Không tìm thấy người thuê để xoá.");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi xoá người thuê: " + e.getMessage());
        }
        return "redirect:/tenants";
    }
    @GetMapping("/rooms")
    public String showVacantRooms(Model model) {
        List<Room> vacantRooms = roomService.getVacantRooms();
        model.addAttribute("vacantRooms", vacantRooms);
        return "User/room_cards";
}

}
