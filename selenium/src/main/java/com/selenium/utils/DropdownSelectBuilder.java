package com.selenium.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectBuilder {
    private WebElement dropdown;
    private Integer index = null;
    private String value = null;
    private String visibleText = null;

    public DropdownSelectBuilder(WebElement dropdown) {
        this.dropdown = dropdown;
    }

    public DropdownSelectBuilder byIndex(int index) {
        this.index = index;
        return this;
    }

    public DropdownSelectBuilder byValue(String value) {
        this.value = value;
        return this;
    }

    public DropdownSelectBuilder byVisibleText(String text) {
        this.visibleText = text;
        return this;
    }

    public void select() {
        Select select = new Select(dropdown);
        if (index != null) {
            select.selectByIndex(index);
        } else if (value != null) {
            select.selectByValue(value);
        } else if (visibleText != null) {
            select.selectByVisibleText(visibleText);
        }
    }
}
