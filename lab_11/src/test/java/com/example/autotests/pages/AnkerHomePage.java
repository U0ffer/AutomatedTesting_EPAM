package com.example.autotests.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerHomePage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String HOME_PAGE_URL = "https://www.anker.com/eu-en/";

    By cartItemHandlerSelector = By.className("CartItem_root__n8ra_");

    By deleteCardItemSelector = By
            .cssSelector("li.CartItem_root__n8ra_:nth-child(1) > div:nth-child(1) > button:nth-child(3)");

    @FindBy(className = "Button_naked__xwcQp")
    private WebElement cartButton;

    public AnkerHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerHomePage openPage() {
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public AnkerHomePage clickOnCartButton() {
        cartButton.click();
        logger.info("Click on cart button");
        return this;
    }

    public AnkerHomePage clickOnDeleteCardItemButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(deleteCardItemSelector).click();
        Thread.sleep(2000);
        logger.info("Cart item was deleted");

        return this;
    }

    public int getCartItemsCount() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> cartItemsHandlers = driver.findElements(cartItemHandlerSelector);
        return cartItemsHandlers.size();
    }
}
