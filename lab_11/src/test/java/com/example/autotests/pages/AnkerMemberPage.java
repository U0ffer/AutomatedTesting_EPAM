package com.example.autotests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerMemberPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String MEMBER_PAGE_URL = "https://mulpass.anker.com/account/";

    @FindBy(xpath = "//div[@id='gatsby-focus-wrapper']/div/div/div/div[3]/div/div/section[2]/div/div/div[2]")
    private WebElement manageAccountShippingAddressesButton;

    @FindBy(className = "styles-module--description--KFnqA")
    private WebElement loggedEmail;

    public AnkerMemberPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerMemberPage openPage() {
        driver.get(MEMBER_PAGE_URL);
        return this;
    }

    public AnkerShippingAddressesPage clickOnManageAccountShippingAddressesButton() {
        manageAccountShippingAddressesButton.click();

        logger.info("Manage account shipping addresses button clicked");
        return new AnkerShippingAddressesPage(driver);
    }

    public String getLoggedEmail() {
        return loggedEmail.getText();
    }
}
