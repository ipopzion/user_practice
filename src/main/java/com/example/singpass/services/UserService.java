package com.example.singpass.services;

import com.example.singpass.entities.User;
import com.example.singpass.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public Optional<User> readUser(Long userId) {
        return userRepository.findById(userId);
    }

    public Optional<String> readUsernameFromUserId(Long userId) {
        Optional<User> user = readUser(userId);
        return Optional.ofNullable(user.get().getUsername());
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

}
