package com.epam.core.mobile.configuration;

import com.epam.core.utilities.property.PropertyDataReader;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Optional;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE;

public final class AddressConfigurator {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String ERROR_LOG_LEVEL = "error";
    private static final String KILL_NODE_COMMAND = "taskkill /F /IM node.exe";
    private static final ThreadLocal<AppiumDriverLocalService> LOCAL_SERVICES = new ThreadLocal<>();

    private AddressConfigurator() {
    }

    public static AppiumDriverLocalService getAppiumDriverLocalService(final int port) {
        if (LOCAL_SERVICES.get() == null) {
            startService(port);
        }
        return LOCAL_SERVICES.get();
    }

    public static void startService(final int port) {
        makePortAvailableIfOccupied(port);
        AppiumDriverLocalService appiumDriverLocalService = new AppiumServiceBuilder()
                .withIPAddress(PropertyDataReader.getProperties(System.getProperty("env"))
                        .getProperty("appium.address"))
                .usingPort(port)
                .withArgument(SESSION_OVERRIDE)
                .withArgument(LOG_LEVEL, ERROR_LOG_LEVEL)
                .build();
        LOCAL_SERVICES.set(appiumDriverLocalService);
        LOCAL_SERVICES.get().start();
        LOGGER.info("Appium server started on port: {}", port);
    }

    public static void stopService() {
        Optional.ofNullable(LOCAL_SERVICES.get()).ifPresent(service -> {
            service.stop();
            LOCAL_SERVICES.remove();
            LOGGER.info("Appium server stopped");
        });
    }

    private static void makePortAvailableIfOccupied(final int port) {
        if (!isPortFree(port)) {
            try {
                Runtime.getRuntime().exec(KILL_NODE_COMMAND);
            } catch (IOException e) {
                LOGGER.warn("Couldn't execute runtime command, message: {}", e.getMessage());
            }
        }
    }

    private static boolean isPortFree(final int port) {
        boolean isFree = true;
        try (ServerSocket ignored = new ServerSocket(port)) {
            LOGGER.info("Specified port - {} is available and ready to use", port);
        } catch (Exception e) {
            isFree = false;
            LOGGER.warn("Specified port - {} is occupied by some process, process will be terminated", port);
        }
        return isFree;
    }

    public static URL getUrl(final String address) {
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            LOGGER.error("url setup is failed, message: {}", e.getMessage());
        }
        return url;
    }
}
