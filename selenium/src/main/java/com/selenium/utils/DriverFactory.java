package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private final WebDriverBuilder builder;

    public DriverFactory(String browser) {
        this.builder = new WebDriverBuilder().withBrowser(browser);
    }

    public DriverFactory withHeadless(boolean headless) {
        if (headless) {
            builder.enableHeadless();
        }
        return this;
    }

    public DriverFactory withMaximized(boolean maximized) {
        if (maximized) {
            builder.enableMaximized();
        }
        return this;
    }

    public DriverFactory withProxy(String proxy) {
        if (proxy != null && !proxy.isEmpty()) {
            builder.withProxy(proxy);
        }
        return this;
    }

    public DriverFactory withDriverPath(String driverPath) {
        if (driverPath != null && !driverPath.isEmpty()) {
            builder.withDriverPath(driverPath);
        }
        return this;
    }

    public WebDriver createDriver() {
        logger.info("Creating WebDriver for browser via factory");
        try {
            return builder.build();
        } catch (IllegalArgumentException e) {
            logger.error("Failed to create WebDriver: {}", e.getMessage(), e);
            throw new IllegalArgumentException("Failed to create WebDriver: " + e.getMessage(), e);
        }
    }
}