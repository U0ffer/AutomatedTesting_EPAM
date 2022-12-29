package com.example.autotests.services;

import java.util.Locale;

import com.example.autotests.models.ShippingAddress;
import com.github.javafaker.Faker;

public class ShippingAddressCreator {
    public static ShippingAddress withFakeData() {
        Faker faker = new Faker(new Locale("en-US"));

        return new ShippingAddress(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().streetAddress() + " " + faker.address().buildingNumber(),
                faker.address().city(),
                faker.address().state(),
                faker.address().zipCode(),
                faker.phoneNumber().cellPhone());
    }
}
