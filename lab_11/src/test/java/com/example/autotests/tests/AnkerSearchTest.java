package com.example.autotests.tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.autotests.pages.AnkerSearchPage;

public class AnkerSearchTest extends CommonConditions {
  @Test(description = "Check blank search")
  public void checkBlankSearch() {
    new AnkerSearchPage(driver).openPage().searchFor("");

    AssertJUnit.assertTrue(driver.getCurrentUrl().contains("https://www.anker.com/eu-en/search?q="));
  }

  @Test(description = "Check search with help keyword")
  public void checkSearchWithHelpKeyword() throws InterruptedException {
    int countOfResultsWithoutHelpWorld = new AnkerSearchPage(driver).openPage().searchFor("charger")
        .getSearchResultsCount();

    int countOfResultsWithHelpWorld = new AnkerSearchPage(driver).openPage().searchFor("buy charger")
        .getSearchResultsCount();

    AssertJUnit.assertTrue(countOfResultsWithHelpWorld == countOfResultsWithoutHelpWorld);
  }

  @Test(description = "Check search case sensitivity")
  public void checkSearchCaseSensitivity() throws InterruptedException {
    int countOfResultsWithLowercase = new AnkerSearchPage(driver).openPage().searchFor("charger")
        .getSearchResultsCount();

    int countOfResultsWithUppercase = new AnkerSearchPage(driver).openPage().searchFor("CHARGER")
        .getSearchResultsCount();

    AssertJUnit.assertTrue(countOfResultsWithLowercase == countOfResultsWithUppercase);
  }
}
