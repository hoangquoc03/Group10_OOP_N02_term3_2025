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
        model.addAttribute("landlords", landlordService.getAllLandlords());
        return "landlord_list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("landlord", new Landlord());
        return "landlord_form";
    }

    // Lưu thông tin chủ trọ mới hoặc đã chỉnh sửa
    @PostMapping("/save")
    public String save(@ModelAttribute("landlord") Landlord landlord) {
        System.out.println("Saving landlord: " + landlord.getName());
        landlordService.saveLandlord(landlord);
        return "redirect:/landlords";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Landlord landlord = landlordService.getLandlordById(id);
        if (landlord != null) {
            model.addAttribute("landlord", landlord);
            return "landlord_form";
        } else {
            return "redirect:/landlords";
        }
    }

    // Xóa chủ trọ
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        landlordService.deleteLandlord(id);
        return "redirect:/landlords";
    }
}
