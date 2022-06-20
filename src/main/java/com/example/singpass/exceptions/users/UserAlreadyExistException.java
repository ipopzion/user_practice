package com.example.singpass.exceptions.users;

import com.example.singpass.exceptions.BusinessException;

public class UserAlreadyExistException extends BusinessException {
    public UserAlreadyExistException(String errorMessage){
        super(errorMessage);
    }
}