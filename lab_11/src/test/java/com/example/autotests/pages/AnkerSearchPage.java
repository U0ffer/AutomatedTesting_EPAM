package com.example.autotests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerSearchPage extends AbstractPage {
    private static final String SEARCH_PAGE_URL = "https://www.anker.com/eu-en/search";
    private static final Logger logger = LogManager.getRootLogger();

    @FindBy(css = ".pl-8")
    private WebElement searchInput;

    By searchResultsCountSelector = By.cssSelector(".py-12");

    public AnkerSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerSearchPage openPage() {
        driver.get(SEARCH_PAGE_URL);
        return this;
    }

    public AnkerSearchPage searchFor(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);

        logger.info("Search for " + searchQuery);

        return this;
    }

    public int getSearchResultsCount() throws InterruptedException {
        Thread.sleep(7000);
        return Integer.parseInt(driver.findElement(searchResultsCountSelector).getText().substring(0, 1));
    }
}
