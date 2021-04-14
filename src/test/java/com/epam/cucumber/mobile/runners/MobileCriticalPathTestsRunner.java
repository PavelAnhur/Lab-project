package com.epam.cucumber.mobile.runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        monochrome = true,
        tags = "@critical-path and @mobile",
        glue = "com.epam.cucumber.mobile",
        features = "classpath:features/mobile")
public class MobileCriticalPathTestsRunner extends BaseMobileTestsRunner {

    @AfterSuite
    public void closeDevice() {
        super.closeDevice();
    }
}
