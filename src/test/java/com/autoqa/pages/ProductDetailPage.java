package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    private By productName = By.xpath("//div[@class='product-information']/h2");
    private By productPrice = By.xpath("//div[@class='product-information']/span/span");
    private By productCategory = By.xpath("//div[@class='product information']/p[contains(text(),'Category')]");
    private By productAvailability = By.xpath("//div[@class='product information']/p[b[contains(text(),'Availability')]]");
    private By productBrand = By.xpath("//div[@class='product information']/p[b[contains(text(),'Brand')]]");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public String getProductCategory() {
        return getText(productCategory);
    }

    public String getProductAvailability() {
        return getText(productAvailability);
    }

    public String getProductBrand() {
        return getText(productBrand);
    }

    public void setQuantity(int quantity) {
        sendKeys(quantityInput, String.valueOf(quantity));
    }
    public void clickAddToCart() {
        click(addToCartButton);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue Shopping')]"))).click();
        } catch (Exception e) { }
    }
}