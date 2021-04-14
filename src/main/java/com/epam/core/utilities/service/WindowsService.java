package com.epam.core.utilities.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public final class WindowsService {
    private static final int TIMEOUT = 15;

    private WindowsService() {
    }

    public static String getNewWindowHandle(final WebDriver webDriver, final Set<String> windowsSet) {
        return (new WebDriverWait(webDriver, TIMEOUT))
                       .until((ExpectedCondition<String>) driver -> {
                           Set<String> newWindowsSet = driver.getWindowHandles();
                           newWindowsSet.removeAll(windowsSet);
                           return newWindowsSet.size() > 0 ? newWindowsSet.iterator().next() : null;
                       });
    }
}
