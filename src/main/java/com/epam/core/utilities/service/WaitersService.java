package com.epam.core.utilities.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class WaitersService {
    private static final int TIMEOUT = 30;
    private static final Logger LOGGER = LogManager.getRootLogger();

    private WaitersService() {
    }

    private static <T> T wait(final WebDriver driver, final ExpectedCondition<T> condition) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(condition);
    }

    private static <T> void waitWithIgnoring(final WebDriver driver, final ExpectedCondition<T> condition) {
        new WebDriverWait(driver, TIMEOUT)
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

    public static void waitUntilVisibilityOfAllElements(final WebDriver driver,
                                                        final List<? extends WebElement> elements) {
        waitWithIgnoring(driver, ExpectedConditions.visibilityOfAllElements((List<WebElement>) elements));
    }

    public static WebElement waitUntilPresenceOfElementAndReturn(final WebDriver driver, final By by) {
        return wait(driver, ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(final WebDriver driver, final WebElement element) {
        waitWithIgnoring(driver, ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeClickableAndReturn(final WebDriver driver, final WebElement element) {
        return wait(driver, ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForVisibilityOfElement(final WebDriver driver, final WebElement element) {
        waitWithIgnoring(driver, ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilPageIsCompletelyLoaded(final WebDriver driver) {
        wait(driver, webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public static void waitForListOfWebElementsVisibility(final WebDriver driver,
                                                          final List<WebElement> webElements) {
        waitWithIgnoring(driver, ExpectedConditions.visibilityOfAllElements(webElements));
    }

    public static void waitUntilTextToBePresentInElement(final WebDriver driver, final WebElement webElement,
                                                         final String text) {
        wait(driver, ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public static void threadSleep(final int millisecondsTimeout) {
        try {
            Thread.sleep(millisecondsTimeout);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
