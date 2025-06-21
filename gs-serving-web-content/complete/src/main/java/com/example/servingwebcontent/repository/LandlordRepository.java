package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepository extends JpaRepository<Landlord, Long> {
}
