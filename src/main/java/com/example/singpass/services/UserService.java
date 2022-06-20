package com.example.singpass.services;

import com.example.singpass.entities.User;
import com.example.singpass.exceptions.users.UserAlreadyExistException;
import com.example.singpass.exceptions.users.UserNotFoundException;
import com.example.singpass.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        String nric = user.getNric();
        if (userRepository.existsByNric(nric)) {
            throw(new UserAlreadyExistException(format("User with NRIC:%s already exists", nric)));
        } else {
            return userRepository.save(user);
        }
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User readUserByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(format("User with ID:%d does not exist", userId)));
    }

    public User readUserByNric(String nric) {
        return userRepository.findByNric(nric).orElseThrow(() ->
                new UserNotFoundException(format("User with NRIC:%s does not exist", nric)));
    }

    public String readUsernameByUserId(Long userId) {
        return readUserByUserId(userId).getUsername();
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
