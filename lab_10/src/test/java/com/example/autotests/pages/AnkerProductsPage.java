package com.example.autotests.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerProductsPage extends AbstractPage {

    private static final String PRODUCTS_PAGE_URL = "https://www.anker.com/eu-en/collections/chargers";

    @FindBy(className = "ProductCard_root__HqXTt")
    private List<WebElement> productHandlers;

    public AnkerProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerProductsPage openPage() {
        driver.get(PRODUCTS_PAGE_URL);
        return this;
    }

    public AnkerSoldOutProductPage clickOnSoldOutProduct() {
        for (WebElement productHandler : productHandlers) {
            if (productHandler.findElement(By.className("ProductCard_price___JB_V")).getText().equals("Sold Out")) {
                productHandler.click();
                return new AnkerSoldOutProductPage(driver, driver.getCurrentUrl());
            }
        }

        throw new RuntimeException("No sold out products found");
    }
}
