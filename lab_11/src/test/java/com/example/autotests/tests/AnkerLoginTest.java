package com.example.autotests.tests;

import org.testng.annotations.Test;

import com.example.autotests.models.User;
import com.example.autotests.pages.AnkerLoginPage;
import com.example.autotests.pages.AnkerMemberPage;
import com.example.autotests.services.UserCreator;

public class AnkerLoginTest extends CommonConditions {
  @Test(description = "Check login with valid credentials")
  public void checkLoginWithValidCredentials() {
    User testUser = UserCreator.withCredentialsFromProperty();
    new AnkerLoginPage(driver).openPage().loginAs(testUser);

    String loggedEmail = new AnkerMemberPage(driver).openPage().getLoggedEmail();

    assert loggedEmail.equals(testUser.getEmail());
  }
}
