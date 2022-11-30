package com.example.autotests.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
  public static ExpectedCondition<Boolean> isModalVisible(WebElement button, By modalSelector) {
    return new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          button.click();
          Thread.sleep(2000);
        } catch (Exception e) {
        }
        return driver.findElement(modalSelector).isDisplayed();
      }
    };
  }
}