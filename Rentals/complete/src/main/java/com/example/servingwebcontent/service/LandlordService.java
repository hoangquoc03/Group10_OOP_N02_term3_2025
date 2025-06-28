package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Landlord;
import com.example.servingwebcontent.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordService {

    private final LandlordRepository landlordRepository;

    public LandlordService(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
    }

    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    public void saveLandlord(Landlord landlord) {
        landlordRepository.save(landlord);
    }

    public Landlord getLandlordById(Integer id) {
        return landlordRepository.findById(id).orElse(null);
    }

    public void deleteLandlord(Integer id) {
        landlordRepository.deleteById(id);
    }
    public long getLandlordCount() {
        return landlordRepository.count();
    }
    public List<Landlord> findAll() {
        return landlordRepository.findAll();
    }
}
