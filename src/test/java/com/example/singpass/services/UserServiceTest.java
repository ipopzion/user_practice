package com.example.singpass.services;

import com.example.singpass.entities.User;
import com.example.singpass.exceptions.users.UserAlreadyExistException;
import com.example.singpass.exceptions.users.UserNotFoundException;
import com.example.singpass.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.example.singpass.constants.MockConstant.*;
import static com.example.singpass.factories.UserFactory.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void itShouldReturnUser_whenUserIsCreated() {
        Mockito.when(userRepository.existsByNric(anyString())).thenReturn(false);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(generateMockUser());
        User user = userService.create(generateMockUser());
        assertEquals(user, generateMockUser());
    }

    @Test
    public void itShouldThrowUserAlreadyExistException_whenNricInDb() {
        Mockito.when(userRepository.existsByNric(anyString())).thenReturn(true);
        assertThrows(UserAlreadyExistException.class,
                () -> userService.create(generateMockUser()));
    }

    @Test
    public void itShouldReturnUser_whenUserIdExistInDb() {
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.ofNullable(generateMockUser()));
        User user = userService.readUserByUserId(mockUserId);
        assertEquals(user, generateMockUser());
        assertEquals(user.getUserId(), mockUserId);
    }

    @Test
    public void itShouldReturnUser_whenNricExistInDb() {
        Mockito.when(userRepository.findByNric(anyString())).thenReturn(Optional.ofNullable(generateMockUser()));
        User user = userService.readUserByNric(mockNric);
        assertEquals(user, generateMockUser());
        assertEquals(user.getNric(), mockNric);
    }

    @Test
    public void itShouldThrowUserNotFoundException_whenUserIdNotInDb() {
        Mockito.when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                () -> userService.readUserByUserId(mockUserId));
    }

    @Test
    public void itShouldThrowUserNotFoundException_whenNricNotInDb() {
        Mockito.when(userRepository.findByNric(anyString())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                () -> userService.readUserByNric(mockNric));
    }
}
