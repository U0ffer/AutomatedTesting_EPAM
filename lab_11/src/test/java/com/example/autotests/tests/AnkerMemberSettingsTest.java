package com.example.autotests.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.autotests.models.ShippingAddress;
import com.example.autotests.pages.AnkerLoginPage;
import com.example.autotests.pages.AnkerShippingAddressesPage;
import com.example.autotests.services.ShippingAddressCreator;
import com.example.autotests.services.UserCreator;

public class AnkerMemberSettingsTest extends CommonConditions {
    @BeforeMethod
    public void setUpTest() {
        new AnkerLoginPage(driver).openPage().loginAs(UserCreator.withCredentialsFromProperty());
    }

    @Test(description = "Check availability of adding new shipping address")
    public void checkAvailabilityOfAddingNewShippingAddress() throws InterruptedException {
        AnkerShippingAddressesPage ankerShippingAddressesPage = new AnkerShippingAddressesPage(driver);
        Integer countOfShippingAddressesBeforeAdding = ankerShippingAddressesPage.openPage()
                .getSavedShippingAddressIds().size();

        ShippingAddress fakeShippingAddress = ShippingAddressCreator.withFakeData();

        ankerShippingAddressesPage.clickOnAddNewShippingAddressButton()
                .enterFirstName(fakeShippingAddress.getFirstName())
                .enterLastName(fakeShippingAddress.getLastName())
                .enterAddressLine1(fakeShippingAddress.getAddress1()).enterCity(fakeShippingAddress.getCity())
                .selectState(fakeShippingAddress.getState())
                .enterZipCode(fakeShippingAddress.getZipCode())
                .enterPhoneNumber(fakeShippingAddress.getPhoneNumber())
                .clickOnSaveShippingAddressButton();

        Integer countOfShippingAddressesAfterAdding = ankerShippingAddressesPage.openPage().getSavedShippingAddressIds()
                .size();

        AssertJUnit.assertTrue(countOfShippingAddressesAfterAdding -
                countOfShippingAddressesBeforeAdding == 1);
    }

    @Test(description = "Check availability of deleting shipping address")
    public void checkAvailabilityOfDeletingShippingAddress() throws InterruptedException {
        AnkerShippingAddressesPage ankerShippingAddressesPage = new AnkerShippingAddressesPage(driver);
        Integer countOfShippingAddressesBeforeDeleting = ankerShippingAddressesPage.openPage()
                .getSavedShippingAddressIds().size();

        ankerShippingAddressesPage.clickOnDeleteShippingAddressButton();

        Integer countOfShippingAddressesAfterDeleting = ankerShippingAddressesPage.openPage()
                .getSavedShippingAddressIds().size();

        AssertJUnit.assertTrue(countOfShippingAddressesBeforeDeleting - countOfShippingAddressesAfterDeleting == 1);
    }
}
