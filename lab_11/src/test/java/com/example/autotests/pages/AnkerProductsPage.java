package com.example.autotests.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerProductsPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String PRODUCTS_PAGE_URL = "https://www.anker.com/eu-en/collections/chargers";

    @FindBy(className = "ProductCard_root__HqXTt")
    private List<WebElement> productHandlers;

    @FindBy(css = "ul.Default_filterUl__SCAt9:nth-child(1) > li:nth-child(1) > button:nth-child(1)")
    private WebElement filterButton;

    @FindBy(css = "ul.Default_filterUl__SCAt9:nth-child(3) > li:nth-child(2) > label:nth-child(1) > p:nth-child(2)")
    private WebElement filterPriceButton;

    public AnkerProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerProductsPage openPage() {
        driver.get(PRODUCTS_PAGE_URL);
        return this;
    }

    public AnkerProductPage clickOnProduct() {
        for (WebElement productHandler : productHandlers) {
            if (!productHandler.findElement(By.className("ProductCard_price___JB_V")).getText().equals("Sold Out")) {
                productHandler.click();
                logger.info("Click on product");
                return new AnkerProductPage(driver, driver.getCurrentUrl());
            }
        }

        throw new RuntimeException("No available products found");
    }

    public AnkerSoldOutProductPage clickOnSoldOutProduct() {
        for (WebElement productHandler : productHandlers) {
            if (productHandler.findElement(By.className("ProductCard_price___JB_V")).getText().equals("Sold Out")) {
                productHandler.click();
                logger.info("Click on sold out product");
                return new AnkerSoldOutProductPage(driver, driver.getCurrentUrl());
            }
        }

        throw new RuntimeException("No sold out products found");
    }

    public AnkerProductsPage clickOnFilterButton() {
        filterButton.click();
        logger.info("Click on filter button");
        return this;
    }

    public AnkerProductsPage clickOnFilterPriceButton() throws InterruptedException {
        filterPriceButton.click();
        logger.info("Click on filter price button");
        Thread.sleep(5000);
        return this;
    }

    public List<String> getProductsPrices() {
        List<String> productsPrices = new ArrayList<String>();
        for (WebElement productHandler : productHandlers) {
            productsPrices.add(productHandler.findElement(By.className("ProductCard_price___JB_V")).getText());
        }
        return productsPrices;
    }
}
