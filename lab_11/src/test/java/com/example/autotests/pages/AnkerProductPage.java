package com.example.autotests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerProductPage extends AbstractPage {
    private final String productPageUrl;
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(className = "Button_secondary__iWbf0")
    private WebElement addToCartButton;

    public AnkerProductPage(WebDriver driver, String productPageUrl) {
        super(driver);
        this.productPageUrl = productPageUrl;
    }

    @Override
    public AnkerProductPage openPage() {
        driver.get(productPageUrl);
        return this;
    }

    public AnkerProductPage clickOnAddToCartButton() throws InterruptedException {
        Thread.sleep(5000);
        addToCartButton.click();
        Thread.sleep(5000);
        logger.info("Add to cart button clicked");
        return this;
    }
}
