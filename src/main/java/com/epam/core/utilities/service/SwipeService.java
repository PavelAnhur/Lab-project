package com.epam.core.utilities.service;
import com.epam.core.mobile.driver.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public final class SwipeService {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final double X_OFFSET_RATIO = 0.5;
    private static final double Y_TOP_OFFSET_RATIO = 0.28;
    private static final double Y_BOTTOM_OFFSET_RATIO = 0.81;
    private static final int NUMBER_OF_SWIPES = 10;
    private static final double SMALL_SWIPE_Y_OFFSET_RATIO = 1.50;

    private SwipeService() {
    }

    public static void swipeToElement(final MobileElement element, final int pressTime) {
        for (int swipe = 1; swipe <= NUMBER_OF_SWIPES; swipe++) {
            LOGGER.info("{} swipe to the element", swipe);
            try {
                swipeScreenByCoordinates(pressTime, Y_TOP_OFFSET_RATIO);
                if (element.isDisplayed()) {
                    checkElementPositionOnPage(element, pressTime);
                    break;
                }
            } catch (NoSuchElementException exception) {
                LOGGER.warn("can't find the element");
            }
        }
    }

    public static void checkElementPositionOnPage(final MobileElement element, final int pressTime) {
        if (element.getCoordinates().onPage().getY()
                    >= MobileDriverManager.getDriver().manage().window().getSize()
                .getHeight() * Y_BOTTOM_OFFSET_RATIO) {
            LOGGER.info("need one small swipe");
            swipeScreenByCoordinates(pressTime, Y_TOP_OFFSET_RATIO * SMALL_SWIPE_Y_OFFSET_RATIO);
        }
    }

    private static void swipeScreenByCoordinates(final int pressTime, final double yTopOffsetRatio) {
        Dimension dimension = MobileDriverManager.getDriver().manage().window().getSize();
        final int xOffset = (int) (dimension.getWidth() * X_OFFSET_RATIO);
        final int yTopOffset = (int) (dimension.getHeight() * yTopOffsetRatio);
        final int yBottomOffset = (int) (dimension.getHeight() * Y_BOTTOM_OFFSET_RATIO);
        LOGGER.info("swipe coordinates: x={}, y_top={}, y_bottom={}", xOffset, yTopOffset, yBottomOffset);
        try {
            new TouchAction<>(MobileDriverManager.getDriver())
                    .press(point(xOffset, yBottomOffset))
                    .waitAction(waitOptions(Duration.ofMillis(pressTime)))
                    .moveTo(point(xOffset, yTopOffset))
                    .release().perform();
        } catch (Exception exception) {
            LOGGER.error("swipeScreen(): TouchAction FAILED\n {}", exception.getMessage());
        }
    }
}
