package com.epam.core.utilities.service;

import com.epam.core.mobile.driver.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;

public final class MobileElementsService {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private MobileElementsService() {
    }

    public static void horizontalScrollToElementWith(final String resourceId, final String textContains) {
        MobileDriverManager.getDriver()
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
                + "resourceId(\"" + resourceId + "\"))"
                + ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"" + textContains + "\"))");
    }

    public static void clickLinkInsideElement(final MobileElement element,
                                              final double xOffsetRatio, final double yOffsetRatio) {
        Point point = element.getLocation();
        LOGGER.debug("Element location: {}", point);
        int x = (int) (point.x + element.getSize().getWidth() * xOffsetRatio);
        LOGGER.debug("Tap on coordinates");
        LOGGER.debug("x: {}", x);
        int y = (int) (point.y + element.getSize().getHeight() * yOffsetRatio);
        LOGGER.debug("y: {}", y);
        new TouchAction<>(MobileDriverManager.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    public static void closeSavePasswordForm() {
        LOGGER.info("close save password form");
        try {
            WaitersService.waitForElementToBeClickableAndReturn(MobileDriverManager.getDriver(),
                    MobileDriverManager.getDriver()
                            .findElement(By.cssSelector("#android:id/autofill_save_no"))).click();
        } catch (NoSuchElementException exception) {
            LOGGER.debug("form didn't appear!");
        }
    }
}
