package com.epam.cucumber.mobile.steps;

import com.epam.core.utilities.service.WaitersService;
import com.epam.cucumber.mobile.commonData.SharingData;
import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.GmailPage;
import com.epam.service.api.GmailAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class GmailSharingStepDefs {
    private static final int TIMEOUT = 10000;
    private static final String KEY = "email content";
    private final SharingData sharingData;
    private final GmailAPI gmailAPI;

    public GmailSharingStepDefs(final SharingData data, final GmailAPI api) {
        this.sharingData = data;
        this.gmailAPI = api;
    }

    @When("the user shares the course with Gmail {string}")
    public void shareCourseWithGmail(final String email) {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).clickFirstCourseFromExplorePage();
        getPage(CoursePage.class).clickShareButton();
        getPage(CoursePage.class).shareWithGmail();
        getPage(GmailPage.class).inputEmail(email);
        sharingData.addDataToMap(KEY, getPage(GmailPage.class).getEmailContent());
        getPage(GmailPage.class).sendEmail();
    }

    @Then("mail is received")
    public void receiveGoogleMail() {
        WaitersService.threadSleep(TIMEOUT);
        gmailAPI.apiRequestVerification(sharingData.getDataForTest().get(KEY));
    }
}
