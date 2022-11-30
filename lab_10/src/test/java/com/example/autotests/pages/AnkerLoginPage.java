package com.example.autotests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnkerLoginPage extends AbstractPage {

    private static final String LOGIN_PAGE_URL = "https://mulpass.anker.com";

    @FindBy(xpath = "//input[@id='Email Address']")
    private WebElement emailInputHandler;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordInputHandler;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement loginButton;

    public AnkerLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerLoginPage openPage() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    public AnkerLoginPage enterEmail(String email) {
        emailInputHandler.sendKeys(email);
        return this;
    }

    public AnkerLoginPage enterPassword(String password) {
        passwordInputHandler.sendKeys(password);
        return this;
    }

    public AnkerMemberPage clickOnLoginButton() {
        loginButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.titleContains("My Account"));

        return new AnkerMemberPage(driver);
    }

    public AnkerMemberPage loginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickOnLoginButton();
    }
}
