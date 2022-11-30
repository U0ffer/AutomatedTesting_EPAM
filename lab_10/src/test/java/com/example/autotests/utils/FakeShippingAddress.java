package com.example.autotests.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakeShippingAddress {
  private String firstName;
  private String lastName;
  private String address1;
  private String city;
  private String state;
  private String zip;
  private String phone;

  public FakeShippingAddress() {
    Faker faker = new Faker(new Locale("en-US"));

    this.firstName = faker.name().firstName();
    this.lastName = faker.name().lastName();
    this.address1 = faker.address().streetAddress() + " " + faker.address().buildingNumber();
    this.city = faker.address().city();
    this.state = faker.address().state();
    this.zip = faker.address().zipCode();
    this.phone = faker.phoneNumber().cellPhone();
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress1() {
    return address1;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getZip() {
    return zip;
  }

  public String getPhone() {
    return phone;
  }
}
