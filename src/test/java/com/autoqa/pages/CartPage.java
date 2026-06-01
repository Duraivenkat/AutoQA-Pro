package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CartPage extends BasePage {

    private By cartProductNames = By.xpath("//table/tbody/tr/td[@class='cart_description']/h4/a");
    private By cartProductPrices = By.xpath("//table/tbody/tr/td[@class='cart_price']/p");
    private By cartProductDelete = By.xpath("//a[@class='cart_quantity_delete']");
    private By emptyCartMsg = By.xpath("//span[@id='empty_cart']");
    private By proceedToCheckoutBtn = By.xpath("//a[@class='btn btn-default check_out']");
    private By cartQuantity = By.xpath("//table/tbody/tr/td[@class='cart_quantity']/button");

    public List<WebElement> getProductNames() {
        return driver.findElements(cartProductNames);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(cartProductPrices);
    }

    public String getFirstProductName() {
        return getText(cartProductNames);
    }

    public String getFirstProductPrice() {
        return getText(cartProductPrices);
    }

    public boolean isCartEmpty() {
        return isDisplayed(emptyCartMsg);
    }

    public void removeFirstProduct() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cartProductDelete));
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", element);
        }
        try {
            wait.until(ExpectedConditions.stalenessOf(element));
        } catch (Exception e) { }
    }

    public int getCartItemCount() {
        return driver.findElements(cartProductNames).size();
    }

    public CheckoutPage clickProceedToCheckout() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        click(proceedToCheckoutBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
        if (!driver.getCurrentUrl().contains("checkout")) {
            String href = btn.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                driver.navigate().to(href);
            }
        }
        return new CheckoutPage();
    }
}
