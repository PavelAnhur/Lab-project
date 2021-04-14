package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BusinessPage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class BusinessSteps {
    private static final String TOPIC_NAME = "Business";
    private final SoftAssert softAssert = new SoftAssert();

    @Then("^the user can see page with the header and list of topics$")
    public void checkHeaderAndListTopics(final List<String> actualTopics) {
        String actualHeader = getPage(BusinessPage.class).getHeaderBusinessPage();
        softAssert.assertEquals(TOPIC_NAME, actualHeader, "Probably, business page didn't open");
        softAssert.assertTrue(getPage(BusinessPage.class).isBusinessSectionIncludesTopics(actualTopics));
        softAssert.assertAll();
    }
}
