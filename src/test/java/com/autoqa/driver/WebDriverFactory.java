package com.autoqa.driver;

import com.autoqa.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String browser) {
        WebDriver webDriver;
        boolean headless = ConfigReader.isHeadless();

        String browserLower = browser.toLowerCase();

        if (browserLower.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            if (headless) {
                chromeOptions.addArguments("--headless");
            }
            chromeOptions.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserLower.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (headless) {
                firefoxOptions.addArguments("--headless");
            }
            webDriver = new FirefoxDriver(firefoxOptions);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        driver.set(webDriver);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
