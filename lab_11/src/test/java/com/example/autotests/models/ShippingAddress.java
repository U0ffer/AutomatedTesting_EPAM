package com.example.autotests.models;

import java.util.Objects;

public class ShippingAddress {
    private String firstName;
    private String lastName;
    private String address1;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    public ShippingAddress(String firstName, String lastName, String address1, String city, String state,
            String zipCode,
            String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
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

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", address1=" + address1 +
                ", city=" + city +
                ", state=" + state +
                ", zipCode=" + zipCode +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ShippingAddress))
            return false;
        ShippingAddress shippingAddress = (ShippingAddress) o;
        return Objects.equals(getFirstName(), shippingAddress.getFirstName()) &&
                Objects.equals(getLastName(), shippingAddress.getLastName()) &&
                Objects.equals(getAddress1(), shippingAddress.getAddress1()) &&
                Objects.equals(getCity(), shippingAddress.getCity()) &&
                Objects.equals(getState(), shippingAddress.getState()) &&
                Objects.equals(getZipCode(), shippingAddress.getZipCode()) &&
                Objects.equals(getPhoneNumber(), shippingAddress.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAddress1(), getCity(), getState(), getZipCode(),
                getPhoneNumber());
    }
}
