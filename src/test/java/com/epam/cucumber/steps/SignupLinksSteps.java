package com.epam.cucumber.steps;

import com.epam.core.utilities.service.TabsSwitcher;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.webdriver.factory.DriverManager;
import com.epam.pages.coursera.CourseraPrivacyNoticePage;
import com.epam.pages.coursera.CourseraTermsOfUsePage;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class SignupLinksSteps {
    private final CourseraPrivacyNoticePage privacyNoticePage = new CourseraPrivacyNoticePage();
    private final CourseraTermsOfUsePage termsOfUsePage = new CourseraTermsOfUsePage();
    private final SoftAssert softAssert = new SoftAssert();

    @Then("the user redirected to the {string} page")
    public void verifyTermsOfUseTitle(final String pageTitle) {
        TabsSwitcher.switchBetweenTabs(1);
        softAssert.assertEquals(termsOfUsePage.getTermsOfUseTitleAsText(), pageTitle);
        TabsSwitcher.switchBetweenTabs(0);
    }

    @Then("the user redirected to {string} page")
    public void verifyPrivacyNoticeTitle(final String pageTitle) {
        WaitersService.waitUntilPageIsCompletelyLoaded(DriverManager.getDriver());
        TabsSwitcher.switchBetweenTabs(2);
        softAssert.assertEquals(privacyNoticePage.getPrivacyNoticeTitleAsText(), pageTitle);
        softAssert.assertAll();
    }
}
