package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxBrowserConfig implements BrowserConfig {
    @Override
    public void setDriverPath(String driverPath) {
        if (driverPath != null) {
            System.setProperty("webdriver.gecko.driver", driverPath);
        }
    }

    @Override
    public AbstractDriverOptions<?> configureOptions(boolean headless, boolean maximized, String proxy) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) options.addArguments("--headless");
        if (proxy != null) options.addArguments("--proxy-server=" + proxy);
        return options;
    }

    @Override
    public WebDriver createDriver(AbstractDriverOptions<?> options) {
        return new FirefoxDriver((FirefoxOptions) options);
    }

    @Override
    public void maximizeWindow(WebDriver driver, boolean maximized) {
        if (maximized) {
            driver.manage().window().maximize();
        }
    }
}