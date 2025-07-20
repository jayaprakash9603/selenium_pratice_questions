package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WebDriverBuilder {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverBuilder.class);
    private String browser = "chrome";
    private boolean headless = false;
    private boolean maximized = false;
    private String proxy = null;
    private String driverPath = null;

    private static final Map<String, BrowserConfig> BROWSER_CONFIGS = new HashMap<>();

    static {
        BROWSER_CONFIGS.put("chrome", new ChromeBrowserConfig());
        BROWSER_CONFIGS.put("firefox", new FirefoxBrowserConfig());
        BROWSER_CONFIGS.put("edge", new EdgeBrowserConfig());
    }

    public WebDriverBuilder withBrowser(String browser) {
        this.browser = browser.toLowerCase();
        return this;
    }

    public WebDriverBuilder enableHeadless() {
        this.headless = true;
        return this;
    }

    public WebDriverBuilder enableMaximized() {
        this.maximized = true;
        return this;
    }

    public WebDriverBuilder withProxy(String proxy) {
        this.proxy = proxy;
        return this;
    }

    public WebDriverBuilder withDriverPath(String driverPath) {
        this.driverPath = driverPath;
        return this;
    }

    public WebDriver build() {
        BrowserConfig config = BROWSER_CONFIGS.get(browser);
        if (config == null) {
            logger.error("Unsupported browser: {}", browser);
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        logger.info("Building WebDriver for browser: {}", browser);
        config.setDriverPath(driverPath);
        AbstractDriverOptions<?> options = config.configureOptions(headless, maximized, proxy);
        WebDriver driver = config.createDriver(options);
        config.maximizeWindow(driver, maximized); // Delegate maximization to BrowserConfig
        return driver;
    }
}