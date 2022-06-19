package com.example.singpass.constants;

import com.example.singpass.entities.User;

public class MockConstant {

    public static Long mockUserId = Long.valueOf(1489);
    public static String mockUsername = "Ah Beng";
    public static String mockNric = "T0123456A";
    public static int mockPhoneNumber = 91234567;
    public static String mockEmailAddress = "ahbeng1489@gmail.com";

    public static User mockUser = User.builder()
            .userId(mockUserId)
            .username(mockUsername)
            .nric(mockNric)
            .phoneNumber(mockPhoneNumber)
            .emailAddress(mockEmailAddress)
            .build();
}
