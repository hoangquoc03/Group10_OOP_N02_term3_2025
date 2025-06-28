package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.Contract;
import com.example.servingwebcontent.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
