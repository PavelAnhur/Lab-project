package com.epam.core.utilities.service;

import com.epam.core.mobile.driver.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public final class ContextSwitcher {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private ContextSwitcher() {
    }

    public static void switchContext(final String context) {
        AndroidDriver<MobileElement> driver = MobileDriverManager.getDriver();
        Set<String> contextHandles = driver.getContextHandles();
        LOGGER.info("Available context: {}", contextHandles);
        contextHandles.forEach(cont -> {
            if (cont.contains(context)) {
                LOGGER.info("context view switch on: {}", cont);
                driver.context(cont);
            }
        });
    }
}
