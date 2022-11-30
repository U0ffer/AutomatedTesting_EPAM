package com.example.autotests.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.autotests.waits.CustomConditions;

public class AnkerSoldOutProductPage extends AbstractPage {

    private final String productPageUrl;

    @FindBy(className = "ProductPurchaseBar_button__eh7EZ")
    private WebElement notifyMeButton;

    private final By emailInputHandlerSelector = By
            .cssSelector(".OutStockNotify_emailInput__U3e0x > input:nth-child(1)");

    private final By submitEmailNotificationButtonSelector = By
            .cssSelector("button.Button_root__G_l9X:nth-child(5)");

    private final By subscriptionResultMessageHandlerSelector = By
            .xpath("//div[@id='purchase']/div[2]/div[10]/div/div/div[2]/div/div/div/div/p");

    public AnkerSoldOutProductPage(WebDriver driver, String productPageUrl) {
        super(driver);
        this.productPageUrl = productPageUrl;
    }

    @Override
    public AnkerSoldOutProductPage openPage() {
        driver.get(productPageUrl);
        return this;
    }

    public AnkerSoldOutProductPage clickOnNotifyMeButton() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        wait.until(CustomConditions.isModalVisible(notifyMeButton, emailInputHandlerSelector));
        return this;
    }

    public AnkerSoldOutProductPage enterSubscriptionEmail(String email) {
        driver.findElement(emailInputHandlerSelector).sendKeys(email);
        return this;
    }

    public AnkerSoldOutProductPage clickOnSubmitEmailNotificationButton() {
        driver.findElement(submitEmailNotificationButtonSelector).click();
        return this;
    }

    public String getSubscriptionResultMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                webDriver -> webDriver.findElement(subscriptionResultMessageHandlerSelector)
                        .getText().contains("Success!"));
        return driver.findElement(subscriptionResultMessageHandlerSelector).getText();
    }
}
