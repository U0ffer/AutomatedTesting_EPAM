package com.example.autotests.tests;

import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.autotests.pages.AnkerProductsPage;

public class AnkerProductFilterTest extends CommonConditions {
  @Test(description = "Check product filter by price")
  public void checkProductFilterByPrice() throws InterruptedException {
    List<String> prices = new AnkerProductsPage(driver).openPage().clickOnFilterButton().clickOnFilterPriceButton()
        .getProductsPrices();

    for (String price : prices) {
      double priceValue = Double.parseDouble(price.substring(4, 9).replace(",", "."));
      AssertJUnit.assertTrue(priceValue <= 20);
    }
  }
}
