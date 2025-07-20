package com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface BrowserConfig {
    void setDriverPath(String driverPath);
    AbstractDriverOptions<?> configureOptions(boolean headless, boolean maximized, String proxy);
    WebDriver createDriver(AbstractDriverOptions<?> options);
    void maximizeWindow(WebDriver driver, boolean maximized);
}