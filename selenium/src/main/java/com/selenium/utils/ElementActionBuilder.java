package com.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementActionBuilder {
    private WebDriver driver;
    private By locator;
    private int waitSeconds = 10;
    private boolean click;
    private boolean clear;
    private String text;

    public ElementActionBuilder(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public ElementActionBuilder waitFor(int seconds) {
        this.waitSeconds = seconds;
        return this;
    }

    public ElementActionBuilder click() {
        this.click = true;
        return this;
    }

    public ElementActionBuilder clear() {
        this.clear = true;
        return this;
    }

    public ElementActionBuilder type(String text) {
        this.text = text;
        return this;
    }

    public void perform() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (clear) element.clear();
        if (text != null) element.sendKeys(text);
        if (click) element.click();
    }
}
