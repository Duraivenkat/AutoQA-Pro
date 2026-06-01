package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.HomePage;
import com.autoqa.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormValidationTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage();
    }

    @Test
    public void testSignupWithEmptyFields() {
        LoginPage loginPage = homePage.clickSignupLogin();
        loginPage.enterSignupName("");
        loginPage.enterSignupEmail("");
        loginPage.clickSignupButton();

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Should stay on login page with empty fields");
    }

    @Test
    public void testInvalidEmailFormat() {
        LoginPage loginPage = homePage.clickSignupLogin();
        loginPage.enterSignupName("TestUser");
        loginPage.enterSignupEmail("invalid-email");
        loginPage.clickSignupButton();

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Should stay on login page with invalid email");
    }

    @Test
    public void testLoginWithEmptyFields() {
        LoginPage loginPage = homePage.clickSignupLogin();
        loginPage.login("", "");

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Should stay on login page with empty fields");
    }
}
