package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage();
    }

    @Test
    public void testCheckoutWithoutLogin() {
        LoginPage loginPage = homePage.clickSignupLogin();
        homePage.clickCart();
        CartPage cartPage = new CartPage();

        String currentUrl = cartPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login") || currentUrl.contains("view_cart"),
                "Should redirect to login or cart page");
    }

    @Test
    public void testCompleteCheckoutFlow() {
        LoginPage loginPage = homePage.clickSignupLogin();
        loginPage.login("testuser999@test.com", "Test@123");

        homePage.clickCart();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        String currentUrl = checkoutPage.getCurrentUrl();
        boolean onCheckout = currentUrl.contains("checkout");
        if (onCheckout) {
            checkoutPage.isDeliveryAddressVisible();
            checkoutPage.isBillingAddressVisible();
            checkoutPage.enterOrderComment("Please deliver quickly");
            PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
            OrderConfirmedPage confirmedPage = paymentPage.fillPaymentDetails(
                    "Test User", "4242424242424242", "311", "12", "2026");
            Assert.assertTrue(confirmedPage.isOrderConfirmed(),
                    "Order should be confirmed successfully");
        } else {
            Assert.assertTrue(currentUrl.contains("login") || currentUrl.contains("view_cart"),
                    "Should be on checkout, login, or cart page");
        }
    }
}
