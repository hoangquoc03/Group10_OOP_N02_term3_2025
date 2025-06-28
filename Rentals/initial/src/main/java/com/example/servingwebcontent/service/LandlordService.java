package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Landlord;
import com.example.servingwebcontent.repository.LandlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandlordService {

    private final LandlordRepository landlordRepository;

    @Autowired
    public LandlordService(LandlordRepository landlordRepository) {
        this.landlordRepository = landlordRepository;
        // Khởi tạo dữ liệu mẫu nếu cơ sở dữ liệu trống
        if (landlordRepository.count() == 0) {
            Landlord l1 = new Landlord();
            l1.setName("Nguyen Van A");
            l1.setPhone("0901234567");
            landlordRepository.save(l1);

            Landlord l2 = new Landlord();
            l2.setName("Tran Thi B");
            l2.setPhone("0912345678");
            landlordRepository.save(l2);

            Landlord l3 = new Landlord();
            l3.setName("Le Van C");
            l3.setPhone("0923456789");
            landlordRepository.save(l3);
        }
    }

    public List<Landlord> getAllLandlords() {
        return landlordRepository.findAll();
    }

    public List<Landlord> getLandlordsNearDueDate() {
        // Logic giả định (thay bằng logic thực tế nếu có ngày đến hạn)
        return landlordRepository.findAll().stream()
                .collect(Collectors.toList());
    }
}