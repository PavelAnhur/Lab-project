package com.epam.core.utilities.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class FrameSwitcher {
    private static final int TIMEOUT = 20;

    private FrameSwitcher() {
    }

    public static void switchToFrameWithWait(final WebDriver driver, final WebElement frame) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(frame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}
