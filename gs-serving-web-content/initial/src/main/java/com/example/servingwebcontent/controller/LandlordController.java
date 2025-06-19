package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Landlord;
import com.example.servingwebcontent.service.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LandlordController {

    private final LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @GetMapping("/landlords")
    public String showAllLandlords(Model model) {
        List<Landlord> list = landlordService.getAllLandlords();
        model.addAttribute("landlords", list);
        return "landlord_list"; // tên file HTML
    }

    @GetMapping("/landlords/near-due")
    public String showLandlordsNearDue(Model model) {
        List<Landlord> nearDueLandlords = landlordService.getLandlordsNearDueDate();
        model.addAttribute("landlords", nearDueLandlords);
        model.addAttribute("title", "Chủ Nhà Gần Đến Hạn");
        return "landlord_list";
    }
}