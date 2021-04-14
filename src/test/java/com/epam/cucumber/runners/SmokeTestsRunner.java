package com.epam.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        monochrome = true,
        tags = "@smoke and @web",
        glue = "com.epam.cucumber",
        features = "classpath:features")
public class SmokeTestsRunner extends AbstractTestNGCucumberTests {
}
