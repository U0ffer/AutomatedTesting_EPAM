package com.example.autotests.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.example.autotests.pages.AnkerProductsPage;
import com.github.javafaker.Faker;

public class AnkerProductsTest extends CommonConditions {
  @Test(description = "Check availability of subscription to sold out product")
  public void checkAvailabilityOfSubscriptionToSoldOutProduct() {
    String fakeEmail = new Faker().internet().emailAddress();

    String subscriptionResultMessage = new AnkerProductsPage(driver).openPage().clickOnSoldOutProduct()
        .clickOnNotifyMeButton()
        .enterSubscriptionEmail(fakeEmail).clickOnSubmitEmailNotificationButton()
        .getSubscriptionResultMessage();

    AssertJUnit.assertTrue(subscriptionResultMessage.contains("Success!"));
  }
}
