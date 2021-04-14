package com.epam.cucumber.mobile.hooks;

import com.epam.core.mobile.driver.MobileDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MobileHook {

    @Before("@mobile")
    public void createSession() {
        MobileDriverManager.getDriver();
    }

    @After("@mobile")
    public void closeSession() {
        MobileDriverManager.getDriver().resetApp();
    }
}
