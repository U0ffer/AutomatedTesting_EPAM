package com.example.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnkerMemberPage extends AbstractPage {

    private static final String MEMBER_PAGE_URL = "https://mulpass.anker.com/account/";

    @FindBy(xpath = "//div[@id='gatsby-focus-wrapper']/div/div/div/div[3]/div/div/section[2]/div/div/div[2]")
    private WebElement manageAccountShippingAddressesButton;

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
        return new AnkerShippingAddressesPage(driver);
    }
}
