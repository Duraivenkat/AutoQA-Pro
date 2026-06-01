package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By signupLoginLink = By.xpath("//a[@href='/login']");
    private By loggedInAsText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By logoutLink = By.xpath("//a[contains(text(),'Logout')]");
    private By productsLink = By.xpath("//a[@href='/products']");
    private By cartLink = By.xpath("//a[@href='/view_cart']");
    private By deleteAccountLink = By.xpath("//a[contains(text(),'Delete Account')]");

    public LoginPage clickSignupLogin() {
        click(signupLoginLink);
        return new LoginPage();
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(loggedInAsText);
    }

    public String getLoggedInUserText() {
        return getText(loggedInAsText);
    }

    public LoginPage clickLogout() {
        click(logoutLink);
        return new LoginPage();
    }

    public ProductsPage clickProducts() {
        click(productsLink);
        return new ProductsPage();
    }

    public void clickCart() {
        click(cartLink);
    }

    public boolean isDeleteAccountVisible() {
        return isDisplayed(deleteAccountLink);
    }

    public AccountCreatedPage clickDeleteAccount() {
        click(deleteAccountLink);
        return new AccountCreatedPage();
    }
}