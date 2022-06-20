package com.example.singpass.services;

import com.example.singpass.entities.User;
import com.example.singpass.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.example.singpass.factories.UserFactory.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void createUserTest() {
        Mockito.when(userService.create(any(User.class))).thenReturn(generateMockUser());
    }

    @Test
    public void readUserTest1() {
        Mockito.when(userService.readUser(any(Long.class))).thenReturn(Optional.ofNullable(generateMockUser()));
    }

    @Test
    public void readUserTest2() {
        Mockito.when(userService.readUser(any(Long.class))).thenReturn(Optional.empty());
    }
}
