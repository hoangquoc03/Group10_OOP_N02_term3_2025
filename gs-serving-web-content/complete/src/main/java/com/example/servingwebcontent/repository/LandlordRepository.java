package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandlordRepository extends JpaRepository<Landlord, Integer> {
    long count(); // Đếm tất cả chủ trọ
}
