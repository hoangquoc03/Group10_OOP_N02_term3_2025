package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Landlord;
import com.example.servingwebcontent.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/landlords")
public class LandlordController {

    @Autowired
    private LandlordService landlordService;

    // Hiển thị danh sách chủ trọ
    @GetMapping
    public String listLandlords(Model model) {
        try {
            model.addAttribute("landlords", landlordService.getAllLandlords());
            return "landlord_list";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể tải danh sách chủ trọ: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị form thêm mới
    @GetMapping("/new")
    public String showForm(Model model) {
        try {
            model.addAttribute("landlord", new Landlord());
            return "landlord_form";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Không thể hiển thị form thêm chủ trọ: " + e.getMessage());
            return "error";
        }
    }

    // Lưu thông tin chủ trọ mới hoặc đã chỉnh sửa
    @PostMapping("/save")
    public String save(@ModelAttribute("landlord") Landlord landlord, Model model) {
        try {
            System.out.println("Saving landlord: " + landlord.getName());
            landlordService.saveLandlord(landlord);
            return "redirect:/landlords";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi lưu chủ trọ: " + e.getMessage());
            return "error";
        }
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        try {
            Landlord landlord = landlordService.getLandlordById(id);
            if (landlord != null) {
                model.addAttribute("landlord", landlord);
                return "landlord_form";
            } else {
                model.addAttribute("errorMessage", "Không tìm thấy chủ trọ với ID: " + id);
                return "error";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi hiển thị form sửa chủ trọ: " + e.getMessage());
            return "error";
        }
    }

    // Xóa chủ trọ
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        try {
            landlordService.deleteLandlord(id);
            return "redirect:/landlords";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Lỗi khi xóa chủ trọ: " + e.getMessage());
            return "error";
        }
    }
}
