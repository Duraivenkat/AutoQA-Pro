package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage {

    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By productNames = By.xpath("//div[@class='productinfo text-center']/p");
    private By productPrices = By.xpath("//div[@class='productinfo text-center']/h2");
    private By viewProductLinks = By.xpath("//a[contains(text(),'View Product')]");
    private By allProductsTitle = By.xpath("//h2[contains(text(),'All Products')]");

    public void enterSearchKeyword(String keyword) {
        sendKeys(searchInput, keyword);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsTitle);
    }

    public boolean isAllProductsVisible() {
        return isDisplayed(allProductsTitle);
    }

    public List<WebElement> getProductNameElements() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPriceElements() {
        return driver.findElements(productPrices);
    }

    public int getProductCount() {
        return driver.findElements(productNames).size();
    }

    public ProductDetailPage clickViewProduct(int index) {
        List<WebElement> products = driver.findElements(viewProductLinks);
        products.get(index).click();
        return new ProductDetailPage();
    }

    public ProductsPage searchProduct(String keyword) {
        enterSearchKeyword(keyword);
        clickSearchButton();
        return this;
    }

    public void clickCategory(String category) {
        click(By.xpath("//a[contains(text(),'" + category + "') and @data-toggle='collapse']"));
    }

    public void clickSubCategory(String subCategory) {
        click(By.xpath("//a[contains(text(),'" + subCategory + "') and not(@data-toggle='collapse')]"));
    }
}