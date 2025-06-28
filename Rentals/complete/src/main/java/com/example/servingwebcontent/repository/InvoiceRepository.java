package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime; 
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByTenantId(Integer tenantId);
    List<Invoice> findByRoomId(Integer roomId);
    List<Invoice> findByCreatedAt(LocalDateTime createdAt);
}
