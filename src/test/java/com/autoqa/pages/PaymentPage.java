package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private By nameOnCard = By.xpath("//input[@data-qa='name-on-card']");
    private By cardNumber = By.xpath("//input[@data-qa='card-number']");
    private By cvcInput = By.xpath("//input[@data-qa='cvc']");
    private By expiryMonth = By.xpath("//input[@data-qa='expiry-month']");
    private By expiryYear = By.xpath("//input[@data-qa='expiry-year']");
    private By payButton = By.xpath("//button[@data-qa='pay-button']");
    private By successMessage = By.id("success_message");

    public void enterNameOnCard(String name) {
        sendKeys(nameOnCard, name);
    }

    public void enterCardNumber(String number) {
        sendKeys(cardNumber, number);
    }

    public void enterCvc(String cvc) {
        sendKeys(cvcInput, cvc);
    }

    public void enterExpiryMonth(String month) {
        sendKeys(expiryMonth, month);
    }

    public void enterExpiryYear(String year) {
        sendKeys(expiryYear, year);
    }

    public OrderConfirmedPage clickPayButton() {
        click(payButton);
        return new OrderConfirmedPage();
    }

    public OrderConfirmedPage fillPaymentDetails(String name, String cardNum, String cvc,
                                                 String month, String year) {
        enterNameOnCard(name);
        enterCardNumber(cardNum);
        enterCvc(cvc);
        enterExpiryMonth(month);
        enterExpiryYear(year);
        return clickPayButton();
    }
}