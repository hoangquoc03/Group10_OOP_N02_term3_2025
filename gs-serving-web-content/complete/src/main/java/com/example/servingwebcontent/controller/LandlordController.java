package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Landlord;
import com.example.servingwebcontent.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/landlords")
public class LandlordController {

    @Autowired
    private LandlordRepository landlordRepository;

    @GetMapping
    public String listLandlords(Model model) {
        List<Landlord> landlords = landlordRepository.findAll();
        model.addAttribute("landlords", landlords);
        return "landlord_list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("landlord", new Landlord());
        return "landlord_form";
    }

    @PostMapping("/save")
    public String saveLandlord(@ModelAttribute Landlord landlord) {
        landlordRepository.save(landlord);
        return "redirect:/landlords";
    }

    @GetMapping("/edit/{id}")
    public String editLandlord(@PathVariable Long id, Model model) {
        Landlord landlord = landlordRepository.findById(id).orElseThrow();
        model.addAttribute("landlord", landlord);
        return "landlord_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteLandlord(@PathVariable Long id) {
        landlordRepository.deleteById(id);
        return "redirect:/landlords";
    }
}
