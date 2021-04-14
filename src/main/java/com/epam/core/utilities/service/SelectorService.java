package com.epam.core.utilities.service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class SelectorService {

    private SelectorService() {
    }

    public static void selectOptionByValue(final WebElement element, final String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectOptionByIndex(final WebElement element, final int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
}
