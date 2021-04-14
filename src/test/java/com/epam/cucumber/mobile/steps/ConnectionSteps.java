package com.epam.cucumber.mobile.steps;

import com.epam.core.utilities.service.ConnectionService;
import com.epam.pages.mobile.coursera.LoginPage;
import io.appium.java_client.android.connection.ConnectionState;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class ConnectionSteps {

    @When("the user turns off wifi and mobile data connection")
    public void turnOffWifiAndMobileDataConnection() {
        ConnectionService.turnWiFiAndMobileDataOff();
    }

    @Then("the user can see {string} message about lost connection")
    public void verifyLostConnectionMessage(final String message) {
        ConnectionState connection;
        try {
            getPage(LoginPage.class).signupLater();
            Assert.assertTrue(getPage(LoginPage.class)
                                      .getNoConnectionText().contains(message));
        } finally {
            connection = ConnectionService.turnWiFiAndMobileDataOn();
        }
        Assert.assertTrue(connection.isWiFiEnabled() && connection.isDataEnabled());
    }
}
