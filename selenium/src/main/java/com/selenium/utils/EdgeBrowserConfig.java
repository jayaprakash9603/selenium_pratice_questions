package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class EdgeBrowserConfig implements BrowserConfig {
    @Override
    public void setDriverPath(String driverPath) {
        if (driverPath != null) {
            System.setProperty("webdriver.edge.driver", driverPath);
        }
    }

    @Override
    public AbstractDriverOptions<?> configureOptions(boolean headless, boolean maximized, String proxy) {
        EdgeOptions options = new EdgeOptions();
        if (headless) options.addArguments("--headless");
        if (maximized) options.addArguments("--start-maximized");
        if (proxy != null) options.addArguments("--proxy-server=" + proxy);
        return options;
    }

    @Override
    public WebDriver createDriver(AbstractDriverOptions<?> options) {
        return new EdgeDriver((EdgeOptions) options);
    }

    @Override
    public void maximizeWindow(WebDriver driver, boolean maximized) {
        // Edge uses --start-maximized, so no post-creation maximization needed
    }
}