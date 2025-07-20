package com.selenium.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertActionBuilder {
    private WebDriver driver;
    private boolean accept = false;
    private boolean dismiss = false;
    private String text = null;

    public AlertActionBuilder(WebDriver driver) {
        this.driver = driver;
    }

    public AlertActionBuilder accept() {
        this.accept = true;
        return this;
    }

    public AlertActionBuilder dismiss() {
        this.dismiss = true;
        return this;
    }

    public AlertActionBuilder sendText(String text) {
        this.text = text;
        return this;
    }

    public void perform() {
        Alert alert = driver.switchTo().alert();
        if (text != null) alert.sendKeys(text);
        if (accept) alert.accept();
        if (dismiss) alert.dismiss();
    }
}
