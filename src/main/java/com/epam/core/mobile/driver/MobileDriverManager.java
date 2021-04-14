package com.epam.core.mobile.driver;
import com.epam.core.mobile.configuration.AddressConfigurator;
import com.epam.core.mobile.configuration.CapabilitiesConfigurator;
import com.epam.core.enums.EnvironmentType;
import com.epam.core.mobile.utils.RequestUtils;
import com.epam.core.utilities.property.PropertyDataReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public final class MobileDriverManager {
    private static final Properties PROPERTIES = PropertyDataReader.getProperties(System.getProperty("env"));
    private static final String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
    private static final String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(
            PROPERTIES.getProperty("env.type").toUpperCase());
    private static final ThreadLocal<AndroidDriver<MobileElement>> DRIVERS = new ThreadLocal<>();
    private static AndroidDriver<MobileElement> driver;

    private MobileDriverManager() {
    }

    public static AndroidDriver<MobileElement> getDriver() {
        if (DRIVERS.get() == null) {
            DRIVERS.set(createDriver());
        }
        return DRIVERS.get();
    }

    private static AndroidDriver<MobileElement> createDriver() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                driver = new AndroidDriver<>(AddressConfigurator.getAppiumDriverLocalService(
                        NumberUtils.toInt(PROPERTIES.getProperty("appium.port"))), CapabilitiesConfigurator
                        .getLocalCapabilities());
                break;
            case MOBILE_CLOUD:
                prepareCloudDevice(PROPERTIES.getProperty("cloud.api.url"),
                                    PROPERTIES.getProperty("cloud.device.serial"),
                                    getCloudKey());
                driver = new AndroidDriver<>(AddressConfigurator.getUrl(getCloudUrl()),
                        CapabilitiesConfigurator.getCloudCapabilities());
                break;
            case SAUCE_LABS:
                driver = new AndroidDriver<>(AddressConfigurator.getUrl(getSauceUrl()),
                        CapabilitiesConfigurator.getSauceLabsCapabilities());
                break;
            default:
                throw new IllegalArgumentException(String.format("Unexpected environment value: %s", ENVIRONMENT_TYPE));
        }
        LOGGER.info("Driver created");
        LOGGER.info("Environment type is: {}", ENVIRONMENT_TYPE);
        return driver;
    }

    private static void prepareCloudDevice(final String url, final String serial, final String key) {
        String bidValue = "0";
        RequestUtils.takeDevice(url, serial, key);
        String fileId = RequestUtils.retrieveAllUploadedArtifactsAndReturnFileId(url, key, bidValue);
        RequestUtils.installApp(url, serial, key, fileId);
    }

    public static void closeDriver() {
        Optional.ofNullable(DRIVERS.get()).ifPresent(driverInstance -> {
            driverInstance.quit();
            driver = null;
            DRIVERS.remove();
            LOGGER.info("Driver closed");
        });
    }

    public static void closeAppium() {
        AddressConfigurator.stopService();
    }

    public static void closeEmulator() {
        try {
            Runtime.getRuntime().exec(String.format("adb -s %s emu kill", PROPERTIES.getProperty("udid")));
            LOGGER.info("Emulator closed");
        } catch (IOException e) {
            LOGGER.error("Emulator was not closed, message {}", e.getMessage());
        }
    }

    public static void closeDevice() {
        RequestUtils.stopUsingDevice(PROPERTIES.getProperty("cloud.api.url"),
                PROPERTIES.getProperty("cloud.device.serial"), getCloudKey());
    }

    private static String getCloudKey() {
        String key = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PROPERTIES.getProperty("cloud.key")))) {
            key = bufferedReader.readLine();
        } catch (IOException e) {
            LOGGER.error("Can't read cloud key txt file, message: {}", e.getMessage());
        }
        return key;
    }

    private static String getCloudUrl() {
        return String.format(PROPERTIES.getProperty("cloud.url"), getCloudKey());
    }

    private static String getSauceUrl() {
        return String.format(PROPERTIES.getProperty("sauce.url"), SAUCE_USERNAME, SAUCE_ACCESS_KEY);
    }
}
