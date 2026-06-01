package com.autoqa.pages;

import com.autoqa.base.BasePage;
import org.openqa.selenium.By;

public class SignupPage extends BasePage {

    private By titleMrRadio = By.id("id_gender1");
    private By titleMrsRadio = By.id("id_gender2");
    private By passwordInput = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By companyInput = By.id("company");
    private By addressInput = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipcodeInput = By.id("zipcode");
    private By mobileInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMrRadio);
        } else {
            click(titleMrsRadio);
        }
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        click(daysDropdown);
        sendKeys(daysDropdown, day);
        click(monthsDropdown);
        sendKeys(monthsDropdown, month);
        click(yearsDropdown);
        sendKeys(yearsDropdown, year);
    }

    public void checkNewsletter() {
        click(newsletterCheckbox);
    }

    public void enterFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void enterCompany(String company) {
        sendKeys(companyInput, company);
    }

    public void enterAddress(String address) {
        sendKeys(addressInput, address);
    }

    public void selectCountry(String country) {
        click(countryDropdown);
        sendKeys(countryDropdown, country);
    }

    public void enterState(String state) {
        sendKeys(stateInput, state);
    }

    public void enterCity(String city) {
        sendKeys(cityInput, city);
    }

    public void enterZipcode(String zipcode) {
        sendKeys(zipcodeInput, zipcode);
    }

    public void enterMobile(String mobile) {
        sendKeys(mobileInput, mobile);
    }

    public AccountCreatedPage clickCreateAccount() {
        click(createAccountButton);
        return new AccountCreatedPage();
    }

    public AccountCreatedPage fillRegistrationForm(String title, String password, String day,
                                                   String month, String year, String firstName,
                                                   String lastName, String address, String country,
                                                   String state, String city, String zipcode,
                                                   String mobile) {
        selectTitle(title);
        enterPassword(password);
        selectDateOfBirth(day, month, year);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipcode(zipcode);
        enterMobile(mobile);
        return clickCreateAccount();
    }
}