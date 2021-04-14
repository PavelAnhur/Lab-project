package com.epam.core.webdriver.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();
    private static final Logger LOGGER = LogManager.getRootLogger();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (DRIVERS.get() == null) {
            DRIVERS.set(WebDriverCreator.setupWebDriver());
        }
        return DRIVERS.get();
    }

    public static void closeDriver() {
        if (DRIVERS.get() != null) {
            try {
                DRIVERS.get().quit();
                DRIVERS.remove();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
