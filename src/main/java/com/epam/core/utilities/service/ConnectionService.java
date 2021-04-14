package com.epam.core.utilities.service;

import com.epam.core.mobile.driver.MobileDriverManager;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConnectionService {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private ConnectionService() {
    }

    public static ConnectionState turnWiFiAndMobileDataOn() {
        LOGGER.info("wifi and mobile data ON");
        return MobileDriverManager.getDriver().setConnection(
                new ConnectionStateBuilder().withWiFiEnabled().withDataEnabled().build());
    }

    public static ConnectionState turnWiFiAndMobileDataOff() {
        LOGGER.info("wifi and mobile data OFF");
        return MobileDriverManager.getDriver().setConnection(
                new ConnectionStateBuilder().withWiFiDisabled().withDataDisabled().build());
    }
}
