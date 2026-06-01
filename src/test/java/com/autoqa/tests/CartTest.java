package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage();
    }

    @Test
    public void testAddProductToCart() {
        ProductsPage productsPage = homePage.clickProducts();
        ProductDetailPage detailPage = productsPage.clickViewProduct(0);

        String productName = detailPage.getProductName();
        String productPrice = detailPage.getProductPrice();
        detailPage.clickAddToCart();

        homePage.clickCart();
        CartPage cartPage = new CartPage();

        Assert.assertEquals(cartPage.getFirstProductName(), productName,
                "Cart should show correct product name");
        Assert.assertTrue(cartPage.getFirstProductPrice().contains(productPrice.replace("Rs. ", "").trim()),
                "Cart should show correct product price");
    }

    @Test
    public void testRemoveProductFromCart() {
        ProductsPage productsPage = homePage.clickProducts();
        ProductDetailPage detailPage = productsPage.clickViewProduct(0);
        detailPage.clickAddToCart();

        homePage.clickCart();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart should have items");

        cartPage.removeFirstProduct();
        Assert.assertTrue(cartPage.isCartEmpty() || cartPage.getCartItemCount() == 0,
                "Cart should be empty after removal");
    }

    @Test
    public void testCartCountUpdates() {
        ProductsPage productsPage = homePage.clickProducts();
        ProductDetailPage detailPage = productsPage.clickViewProduct(0);
        detailPage.clickAddToCart();

        homePage.clickCart();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart count should be > 0");
    }
}
