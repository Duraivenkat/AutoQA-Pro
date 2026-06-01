package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class OrderConfirmedPage extends BasePage {

    private By successMessage = By.xpath("//div[@id='success_message']/div");
    private By orderConfirmedText = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public boolean isOrderConfirmed() {
        return isDisplayed(orderConfirmedText);
    }

    public HomePage clickContinue() {
        click(continueBtn);
        return new HomePage();
    }
}
