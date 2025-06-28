package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    long countByRole(User.Role role);
    List<User> findAllByUsername(String username);
}
