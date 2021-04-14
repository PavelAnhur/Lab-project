package com.epam.cucumber.mobile.runners;

import com.epam.core.enums.EnvironmentType;
import com.epam.core.mobile.driver.MobileDriverManager;
import com.epam.core.utilities.property.PropertyDataReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import java.util.Properties;

public class BaseMobileTestsRunner extends AbstractTestNGCucumberTests {
    private static final Properties PROPERTIES = PropertyDataReader.getProperties(System.getProperty("env"));
    private static final EnvironmentType ENVIRONMENT_TYPE = EnvironmentType.valueOf(
            PROPERTIES.getProperty("env.type").toUpperCase());

    public void closeDevice() {
        switch (ENVIRONMENT_TYPE) {
            case LOCAL:
                MobileDriverManager.closeDriver();
                MobileDriverManager.closeAppium();
                MobileDriverManager.closeEmulator();
                break;
            case MOBILE_CLOUD:
                MobileDriverManager.closeDevice();
                MobileDriverManager.closeDriver();
                break;
            default:
                MobileDriverManager.closeDriver();
        }
    }
}
