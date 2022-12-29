package com.example.autotests.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.autotests.pages.AnkerHomePage;
import com.example.autotests.pages.AnkerProductsPage;

public class AnkerCartTest extends CommonConditions {
  @Test(description = "Check adding product to cart")
  public void checkAddingProductToCart() throws InterruptedException {
    AnkerHomePage ankerHomePage = new AnkerHomePage(driver);
    Integer countOfProductsInCartBeforeAdding = ankerHomePage.openPage().getCartItemsCount();

    System.out.println(countOfProductsInCartBeforeAdding);

    new AnkerProductsPage(driver).openPage().clickOnProduct().clickOnAddToCartButton();
    Thread.sleep(5000);

    Integer countOfProductsInCartAfterAdding = ankerHomePage.openPage().getCartItemsCount();

    AssertJUnit.assertTrue(countOfProductsInCartAfterAdding - countOfProductsInCartBeforeAdding == 1);
  }

  @Test(description = "Check removing product from cart")
  public void checkRemovingProductFromCart() throws InterruptedException {
    AnkerHomePage ankerHomePage = new AnkerHomePage(driver);
    Integer countOfProductsInCartBeforeRemoving = ankerHomePage.openPage().getCartItemsCount();

    new AnkerProductsPage(driver).openPage().clickOnProduct().clickOnAddToCartButton();

    Integer countOfProductsInCartAfterAdding = ankerHomePage.openPage().getCartItemsCount();

    AssertJUnit.assertTrue(countOfProductsInCartAfterAdding - countOfProductsInCartBeforeRemoving == 1);

    new AnkerHomePage(driver).openPage().clickOnCartButton().clickOnDeleteCardItemButton();

    Integer countOfProductsInCartAfterRemoving = ankerHomePage.openPage().getCartItemsCount();

    AssertJUnit.assertTrue(countOfProductsInCartAfterRemoving - countOfProductsInCartAfterAdding == -1);
  }
}
