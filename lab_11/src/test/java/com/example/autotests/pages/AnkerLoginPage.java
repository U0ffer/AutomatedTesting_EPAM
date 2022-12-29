package com.example.autotests.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.autotests.models.User;

public class AnkerLoginPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
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
        logger.info("Login page opened");
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

    public AnkerMemberPage loginAs(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());

        logger.info("Login as " + user.getEmail());
        return clickOnLoginButton();
    }
}
