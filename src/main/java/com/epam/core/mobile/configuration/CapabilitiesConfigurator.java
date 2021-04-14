package com.epam.core.mobile.configuration;

import com.epam.core.mobile.utils.RequestUtils;
import com.epam.core.utilities.property.PropertyDataReader;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.util.Properties;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public final class CapabilitiesConfigurator {
    private static final String BROWSER_PATH_KEY = "chromedriverExecutableDir";
    private static final Properties PROPERTIES = PropertyDataReader.getProperties(System.getProperty("env"));
    private static final String ACCEPT_ALERTS_CONF_KEY = "autoAcceptAlerts";
    private static final String POPUP_BLOCKING_CONF_KEY = "disable-popup-blocking";

    private CapabilitiesConfigurator() {
    }

    public static DesiredCapabilities getLocalCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(UDID, PROPERTIES.getProperty("udid"));
        capabilities.setCapability(AVD, PROPERTIES.getProperty("local.device.name"));
        capabilities.setCapability(APP, new File(String.valueOf(PROPERTIES.getProperty("app.path"))).getAbsolutePath());
        capabilities.setCapability(BROWSER_PATH_KEY, PROPERTIES.getProperty("chrome.path"));
        capabilities.setCapability(ACCEPT_ALERTS_CONF_KEY, true);
        capabilities.setCapability(POPUP_BLOCKING_CONF_KEY, false);
        setCommonCapabilities(capabilities);
        return capabilities;
    }

    public static DesiredCapabilities getCloudCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(UDID, PROPERTIES.getProperty("cloud.device.serial"));
        capabilities.setCapability(NO_RESET, true);
        setCommonCapabilities(capabilities);
        return capabilities;
    }

    public static void setCommonCapabilities(final DesiredCapabilities capabilities) {
        capabilities.setCapability(PLATFORM_NAME, PROPERTIES.getProperty("platform.name"));
        capabilities.setCapability(PLATFORM_VERSION, PROPERTIES.getProperty("platform.version"));
        capabilities.setCapability(APP_PACKAGE, PROPERTIES.getProperty("app.package"));
        capabilities.setCapability(APP_ACTIVITY, PROPERTIES.getProperty("app.activity"));
        capabilities.setCapability(AUTOMATION_NAME, PROPERTIES.getProperty("automation.name"));
    }

    public static DesiredCapabilities getSauceLabsCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(APP, String.format(PROPERTIES.getProperty("app.path"), RequestUtils.getFileName()));
        capabilities.setCapability(DEVICE_NAME, PROPERTIES.getProperty("device.name"));
        capabilities.setCapability(BROWSER_NAME, "");
        setCommonCapabilities(capabilities);
        return capabilities;
    }
}
