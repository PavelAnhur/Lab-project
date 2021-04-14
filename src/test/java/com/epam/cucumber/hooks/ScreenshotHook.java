package com.epam.cucumber.hooks;

import com.epam.core.utilities.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class ScreenshotHook {

    @After("@web")
    public void takeScreenshot(final Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotService.saveScreenshot();
        }
    }
}
