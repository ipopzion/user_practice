package com.example.singpass.factories;

import com.example.singpass.entities.User;

import static com.example.singpass.constants.MockConstant.*;

public class UserFactory {

    public static User generateMockUser() {
        User mockUser = User.builder()
                .userId(mockUserId)
                .username(mockUsername)
                .nric(mockNric)
                .phoneNumber(mockPhoneNumber)
                .emailAddress(mockEmailAddress)
                .build();
        return mockUser;
    }
}
