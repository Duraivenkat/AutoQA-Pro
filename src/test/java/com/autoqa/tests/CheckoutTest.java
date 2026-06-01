package com.autoqa.tests;

import com.autoqa.base.BaseTest;
import com.autoqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

public class CheckoutTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage();
    }

    private HomePage ensureLoggedIn() {
        LoginPage loginPage = homePage.clickSignupLogin();
        String email = UUID.randomUUID().toString().substring(0, 8) + "@test.com";
        String password = "Pass123!";
        loginPage.signup("Test User " + email, email);
        SignupPage signupPage = new SignupPage();
        signupPage.fillRegistrationForm("Mr", password, "1", "January", "1990",
                "Test", "User", "123 Main St", "United States",
                "California", "Los Angeles", "90001", "1234567890");
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
        Assert.assertTrue(accountCreatedPage.isAccountCreated(), "Account should be created");
        return accountCreatedPage.clickContinue();
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
        homePage = ensureLoggedIn();

        ProductsPage productsPage = homePage.clickProducts();
        ProductDetailPage detailPage = productsPage.clickViewProduct(0);
        detailPage.clickAddToCart();

        homePage.clickCart();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckout();

        Assert.assertTrue(checkoutPage.isDeliveryAddressVisible(), "Delivery address should be visible");
        Assert.assertTrue(checkoutPage.isBillingAddressVisible(), "Billing address should be visible");

        checkoutPage.enterOrderComment("Please deliver quickly");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();

        OrderConfirmedPage confirmedPage = paymentPage.fillPaymentDetails(
                "Test User", "4242424242424242", "311", "12", "2026");

        Assert.assertTrue(confirmedPage.isOrderConfirmed(),
                "Order should be confirmed successfully");
    }
}
