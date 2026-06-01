package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {

    private By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By accountDeletedMessage = By.xpath("//h2[@data-qa='account-deleted']");

    public String getAccountCreatedMessage() {
        return getText(accountCreatedMessage);
    }

    public String getAccountDeletedMessage() {
        return getText(accountDeletedMessage);
    }

    public boolean isAccountCreated() {
        return isDisplayed(accountCreatedMessage);
    }

    public boolean isAccountDeleted() {
        return isDisplayed(accountDeletedMessage);
    }

    public HomePage clickContinue() {
        click(continueButton);
        return new HomePage();
    }
}