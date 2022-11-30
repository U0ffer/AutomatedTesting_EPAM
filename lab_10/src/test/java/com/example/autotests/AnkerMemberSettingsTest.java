package com.example.autotests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.autotests.pages.AnkerLoginPage;
import com.example.autotests.pages.AnkerShippingAddressesPage;
import com.example.autotests.utils.FakeShippingAddress;

public class AnkerMemberSettingsTest {
    private WebDriver driver;
    private FakeShippingAddress fakeShippingAddress;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        fakeShippingAddress = new FakeShippingAddress();
        AnkerLoginPage loginPage = new AnkerLoginPage(driver);
        loginPage.openPage().loginAs("mmazko66@gmail.com", "Maks_33328");
    }

    @Test(description = "Check availability of adding new shipping address")
    public void checkAvailabilityOfAddingNewShippingAddress() throws InterruptedException {
        AnkerShippingAddressesPage ankerShippingAddressesPage = new AnkerShippingAddressesPage(driver);
        Integer countOfShippingAddressesBeforeAdding = ankerShippingAddressesPage.openPage()
                .getSavedShippingAddressIds().size();

        ankerShippingAddressesPage.openPage().clickOnAddNewShippingAddressButton()
                .enterFirstName(fakeShippingAddress.getFirstName())
                .enterLastName(fakeShippingAddress.getLastName())
                .enterAddressLine1(fakeShippingAddress.getAddress1()).enterCity(fakeShippingAddress.getCity())
                .selectState(fakeShippingAddress.getState())
                .enterZipCode(fakeShippingAddress.getZip()).enterPhoneNumber("1234567890")
                .clickOnSaveShippingAddressButton();

        Integer countOfShippingAddressesAfterAdding = ankerShippingAddressesPage.openPage().getSavedShippingAddressIds()
                .size();

        AssertJUnit.assertTrue(countOfShippingAddressesAfterAdding - countOfShippingAddressesBeforeAdding == 1);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
