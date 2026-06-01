package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private By deliveryAddress = By.id("address_delivery");
    private By billingAddress = By.id("address_invoice");
    private By orderComment = By.xpath("//textarea[@name='message']");
    private By placeOrderBtn = By.xpath("//a[@href='/payment']");
    private By cartTotalPrice = By.xpath("//p[@class='cart_total_price']");

    public boolean isDeliveryAddressVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(deliveryAddress));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isBillingAddressVisible() {
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(billingAddress));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterOrderComment(String comment) {
        sendKeys(orderComment, comment);
    }

    public String getTotalPrice() {
        return getText(cartTotalPrice);
    }

    public PaymentPage clickPlaceOrder() {
        click(placeOrderBtn);
        return new PaymentPage();
    }
}
