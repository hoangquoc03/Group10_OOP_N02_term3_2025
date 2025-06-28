package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
