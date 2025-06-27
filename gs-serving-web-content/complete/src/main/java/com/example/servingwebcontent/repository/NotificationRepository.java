package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByRecipientRole(String role);
}
