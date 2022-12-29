package com.example.autotests.services;

import com.example.autotests.models.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testEmail";
    public static final String TESTDATA_USER_PASSWORD = "testPassword";

    public static User withCredentialsFromProperty() {
        // return new User("123", "123");
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyUsername() {
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME), "");
    }
}
