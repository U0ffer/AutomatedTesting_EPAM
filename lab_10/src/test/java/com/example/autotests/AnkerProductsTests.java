package com.example.autotests;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.autotests.pages.AnkerProductsPage;
import com.github.javafaker.Faker;

public class AnkerProductsTests {
    private WebDriver driver;
    private String fakeEmail;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);

        fakeEmail = new Faker().internet().emailAddress();
    }

    @Test(description = "Check availability of subscription to sold out product")
    public void checkAvailabilityOfSubscriptionToSoldOutProduct() {
        String subscriptionResultMessage = new AnkerProductsPage(driver).openPage().clickOnSoldOutProduct()
                .clickOnNotifyMeButton()
                .enterSubscriptionEmail(fakeEmail).clickOnSubmitEmailNotificationButton()
                .getSubscriptionResultMessage();

        AssertJUnit.assertTrue(subscriptionResultMessage.contains("Success!"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
