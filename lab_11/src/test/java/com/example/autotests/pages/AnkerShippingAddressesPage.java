package com.example.autotests.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AnkerShippingAddressesPage extends AbstractPage {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String SHIPPING_ADDRESSES_PAGE_URL = "https://us.anker.com/account/addresses";

    By savedShippingAddressHandlerSelector = By.className("address_table");

    private By DeleteShippingAddressButton = By
            .cssSelector("div.address_table:nth-child(2) > span:nth-child(3) > a:nth-child(1)");

    @FindBy(xpath = "//a[contains(text(),'Add a New Address')]")
    private WebElement addNewShippingAddressButton;

    @FindBy(xpath = "//input[@id='address_first_name_new']")
    private WebElement firstNameInputHandler;

    @FindBy(xpath = "//input[@id='address_last_name_new']")
    private WebElement lastNameInputHandler;

    @FindBy(xpath = "//input[@id='address_address1_new']")
    private WebElement address1InputHandler;

    @FindBy(xpath = "//input[@id='address_address2_new']")
    private WebElement address2InputHandler;

    @FindBy(xpath = "//input[@id='address_city_new']")
    private WebElement cityInputHandler;

    @FindBy(xpath = "//select[@id='address_province_new']")
    private WebElement stateInputHandler;

    @FindBy(xpath = "//input[@id='address_zip_new']")
    private WebElement zipInputHandler;

    @FindBy(xpath = "//input[@id='address_phone_new']")
    private WebElement phoneInputHandler;

    @FindBy(xpath = "//a[contains(text(),'Add Address')]")
    private WebElement saveShippingAddressButton;

    public AnkerShippingAddressesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AnkerShippingAddressesPage openPage() {
        driver.get(SHIPPING_ADDRESSES_PAGE_URL);
        return this;
    }

    public AnkerShippingAddressesPage clickOnAddNewShippingAddressButton() {
        addNewShippingAddressButton.click();
        return this;
    }

    public AnkerShippingAddressesPage enterFirstName(String firstName) {
        firstNameInputHandler.sendKeys(firstName);
        return this;
    }

    public AnkerShippingAddressesPage enterLastName(String lastName) {
        lastNameInputHandler.sendKeys(lastName);
        return this;
    }

    public AnkerShippingAddressesPage enterAddressLine1(String addressLine1) {
        address1InputHandler.sendKeys(addressLine1);
        return this;
    }

    public AnkerShippingAddressesPage enterAddressLine2(String addressLine2) {
        address2InputHandler.sendKeys(addressLine2);
        return this;
    }

    public AnkerShippingAddressesPage enterCity(String city) {
        cityInputHandler.sendKeys(city);
        return this;
    }

    public AnkerShippingAddressesPage selectState(String state) {
        Select select = new Select(stateInputHandler);
        select.selectByVisibleText(state);
        return this;
    }

    public AnkerShippingAddressesPage enterZipCode(String zipCode) {
        zipInputHandler.sendKeys(zipCode);
        return this;
    }

    public AnkerShippingAddressesPage enterPhoneNumber(String phoneNumber) {
        phoneInputHandler.sendKeys(phoneNumber);
        return this;
    }

    public AnkerShippingAddressesPage clickOnSaveShippingAddressButton() throws InterruptedException {
        Thread.sleep(5000);
        saveShippingAddressButton.click();
        Thread.sleep(5000);
        return this;
    }

    public AnkerShippingAddressesPage clickOnDeleteShippingAddressButton() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(DeleteShippingAddressButton).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        return new AnkerShippingAddressesPage(driver);
    }

    public List<String> getSavedShippingAddressIds() {
        List<WebElement> savedShippingAddressHandlers = driver.findElements(savedShippingAddressHandlerSelector);
        List<String> savedShippingAddressIds = new ArrayList<String>();

        for (WebElement addressHandler : savedShippingAddressHandlers) {
            String addressId = addressHandler.getAttribute("data-id");
            savedShippingAddressIds.add(addressId);
        }
        return savedShippingAddressIds;
    }

    public AnkerShippingAddressesPage addNewShippingAddress(String firstName, String lastName, String addressLine1,
            String addressLine2, String city, String state, String zipCode, String phoneNumber)
            throws InterruptedException {
        clickOnAddNewShippingAddressButton();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddressLine1(addressLine1);
        enterAddressLine2(addressLine2);
        enterCity(city);
        selectState(state);
        enterZipCode(zipCode);
        enterPhoneNumber(phoneNumber);

        logger.info("New shipping address was added");
        return clickOnSaveShippingAddressButton();
    }
}
