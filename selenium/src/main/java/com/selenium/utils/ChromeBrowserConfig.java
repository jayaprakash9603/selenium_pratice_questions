package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChromeBrowserConfig implements BrowserConfig {
    private static final Logger logger = LoggerFactory.getLogger(ChromeBrowserConfig.class);

    @Override
    public void setDriverPath(String driverPath) {
        if (driverPath != null && !driverPath.isEmpty()) {
            logger.info("Setting Chrome driver path: {}", driverPath);
            System.setProperty("webdriver.chrome.driver", driverPath);
        } else {
            logger.warn("No Chrome driver path specified; relying on system PATH or Selenium Manager.");
            System.clearProperty("webdriver.chrome.driver");
        }
    }

    @Override
    public AbstractDriverOptions<?> configureOptions(boolean headless, boolean maximized, String proxy) {
        ChromeOptions options = new ChromeOptions();
        if (headless) options.addArguments("--headless=new");
        if (maximized) options.addArguments("--start-maximized");
        if (proxy != null) options.addArguments("--proxy-server=" + proxy);
        logger.info("Configured ChromeOptions: headless={}, maximized={}, proxy={}", headless, maximized, proxy);
        return options;
    }

    @Override
    public WebDriver createDriver(AbstractDriverOptions<?> options) {
        logger.info("Creating ChromeDriver with options: {}", options);
        return new ChromeDriver((ChromeOptions) options);
    }

    @Override
    public void maximizeWindow(WebDriver driver, boolean maximized) {
        if (maximized) {
            try {
                logger.info("Maximizing Chrome window using driver.manage().window().maximize() as fallback");
                driver.manage().window().maximize();
            } catch (Exception e) {
                logger.error("Failed to maximize Chrome window: {}", e.getMessage(), e);
            }
        } else {
            logger.debug("Maximize not requested for Chrome window");
        }
    }
}