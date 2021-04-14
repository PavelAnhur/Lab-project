package com.epam.cucumber.mobile.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        monochrome = true,
        tags = "@pavel",
        glue = "com.epam.cucumber.mobile",
        features = "classpath:features/mobile")
public class MobilePavelTestsRunner extends BaseMobileTestsRunner {
}
