package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByTenantId(Integer tenantId);
    List<Feedback> findByRoomId(Integer roomId);
}
