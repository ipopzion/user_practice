package com.example.singpass.exceptions.users;

import com.example.singpass.exceptions.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}