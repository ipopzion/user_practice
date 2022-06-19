package com.example.singpass.services;

import com.example.singpass.entities.User;
import com.example.singpass.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static com.example.singpass.constants.MockConstant.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void confirmEquals() {
        assertEquals(1, 1);
    }

    @Test
    public void createUserTest() {
        assertEquals(mockUser, userService.create(mockUser));
    }

    @Test
    public void readUserTest() {
        User testUser = mockUser;
        assertEquals(mockUser, userService.readUser(1489L).get());
    }
}
