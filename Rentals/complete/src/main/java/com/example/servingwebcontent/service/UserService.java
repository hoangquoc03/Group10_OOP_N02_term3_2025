package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.User;
import com.example.servingwebcontent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    } 
    public User getUserByUsername(String username) {
    List<User> users = userRepository.findAllByUsername(username);
    if (users.isEmpty()) return null;
    if (users.size() > 1) {
        System.err.println("⚠️ Có nhiều hơn 1 user trùng username: " + username);
    }
    return users.get(0); // lấy bản ghi đầu tiên
   }

    public long countByRole(User.Role role) {
        return userRepository.countByRole(role);
    }
}
