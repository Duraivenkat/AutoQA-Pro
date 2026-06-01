package com.autoqa.base;

import com.autoqa.config.ConfigReader;
import com.autoqa.driver.WebDriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        WebDriverFactory.setDriver(browser);
        WebDriverFactory.getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
