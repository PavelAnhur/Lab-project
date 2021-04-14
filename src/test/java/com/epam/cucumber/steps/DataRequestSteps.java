package com.epam.cucumber.steps;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.pages.coursera.CourseraAccountSettingsPage;
import com.epam.pages.gmail.GmailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class DataRequestSteps {

    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();
    private final GmailPage gmailPage = new GmailPage();
    private final Properties properties = PropertyDataReader.getProperties("tests-data");

    @When("the user requests data report")
    public void getReportData() {
        accountSettingsPage.clickSendReportButton();
    }

    @Then("the report received to the e-mail or a message received that the report has already been sent on this day")
    public void checkDataRequest() {
        String keyword = properties.getProperty("data.release");
        Boolean sendResult = accountSettingsPage.confirmSendDataReport();
        gmailPage.goToGmailPage();
        Boolean readResult = gmailPage.selectionLetter(keyword);
        Assert.assertEquals(sendResult, readResult, "The message didn't come on the email!");
    }
}
