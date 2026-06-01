package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMsg = By.xpath("//form[@action='/login']/p");
    private By signupNameInput = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");

    public void enterLoginEmail(String email) {
        sendKeys(loginEmailInput, email);
    }

    public void enterLoginPassword(String password) {
        sendKeys(loginPasswordInput, password);
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage();
    }

    public HomePage login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        return clickLoginButton();
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMsg);
    }

    public void enterSignupName(String name) {
        sendKeys(signupNameInput, name);
    }

    public void enterSignupEmail(String email) {
        sendKeys(signupEmailInput, email);
    }

    public SignupPage clickSignupButton() {
        click(signupButton);
        return new SignupPage();
    }

    public SignupPage signup(String name, String email) {
        enterSignupName(name);
        enterSignupEmail(email);
        return clickSignupButton();
    }
}