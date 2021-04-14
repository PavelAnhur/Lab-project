package com.epam.core.utilities.service;

import com.epam.core.mobile.driver.MobileDriverManager;
import com.epam.core.webdriver.factory.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class WebElementsService {
    private static final int NUMBER_OF_ATTEMPTS = 10;
    private static final int PAUSE_TIME = 1000;
    private static final Logger LOGGER = LogManager.getRootLogger();

    private WebElementsService() {
    }

    public static List<String> getListOfWebElementsText(final List<? extends WebElement> elements) {
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static List<Double> getListOfDoubleFromElementsText(final List<WebElement> elements) {
        List<Double> doubleList = new ArrayList<>();
        elements.forEach(element -> {
            double doubleValue = Double.parseDouble(element.getText());
            doubleList.add(doubleValue);
        });
        return doubleList;
    }

    public static void clearInputFieldAndSendNewValue(final WebElement input, final String newValue) {
        new Actions(((WrapsDriver) DriverManager.getDriver()).getWrappedDriver())
                .doubleClick(input).sendKeys(Keys.DELETE).build().perform();
        input.sendKeys(newValue);
    }

    public static void clickIgnoringStale(final WebElement element) {
        for (int attempts = 0; attempts < NUMBER_OF_ATTEMPTS; attempts++) {
            try {
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                LOGGER.info("Stale element reference exception!");
            }
        }
    }

    public static void scrollToElementAndClickToIt(final WebElement element) {
        WaitersService.waitForElementToBeClickable(DriverManager.getDriver(), element);
        Point elementPoint = element.getLocation();
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("scroll(0, " + elementPoint.getX() + ");");
        new Actions(((WrapsDriver) DriverManager.getDriver()).getWrappedDriver())
                .moveToElement(element).pause(PAUSE_TIME).click().build().perform();
    }

    public static void clickToElementFromListByName(final List<? extends WebElement> listElements, final String name) {
        listElements.stream().filter(item -> item.getText().contains(name)).findFirst().get().click();
    }

    public static void closeUpdateForm() {
        try {
            LOGGER.debug("close update form");
            MobileDriverManager.getDriver()
                    .findElementByAndroidUIAutomator("new UiSelector().textContains(\"Dismiss\")")
                    .click();
        } catch (NoSuchElementException exception) {
            LOGGER.debug("doesn't need to update!");
        }
    }
}
