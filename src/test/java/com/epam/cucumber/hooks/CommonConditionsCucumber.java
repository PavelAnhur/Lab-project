package com.epam.cucumber.hooks;

import com.epam.core.webdriver.factory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CommonConditionsCucumber {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Before("@web")
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
    }

    @After("@web")
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
