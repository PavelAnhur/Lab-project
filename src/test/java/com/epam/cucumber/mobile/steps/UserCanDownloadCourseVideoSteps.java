package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.DownloadsPage;
import com.epam.pages.mobile.coursera.LearnPage;
import com.epam.pages.mobile.coursera.PhotoCoursePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.asserts.SoftAssert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class UserCanDownloadCourseVideoSteps {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String EMPTY_STATE_HEADER = "Download your courses and learn on the go";

    @When("the user opens course and starts video downloading")
    public void openCourseAndStartVideoDownloading() {
        getPage(LearnPage.class).openCourseHomePage();
        getPage(PhotoCoursePage.class).tapDownloadButton();
    }

    @Then("the downloading started, course {string} appeared in downloads menu section")
    public void verifyThatDownloadingStarted(final String courseName) {
        getPage(PhotoCoursePage.class).getBack();
        getPage(BottomSection.class).navigateToDownloads();
        SoftAssert softAssert = new SoftAssert();
        try {
            softAssert.assertEquals(getPage(DownloadsPage.class).getCourseName(), courseName,
                    "Downloading wasn't started");
        } catch (TimeoutException exception) {
            LOGGER.warn("downloaded course wasn't appeared");
            getPage(BottomSection.class).navigateToProfile();
            getPage(BottomSection.class).navigateToDownloads();
            softAssert.assertEquals(getPage(DownloadsPage.class).getCourseName(), courseName,
                    "Downloading wasn't started");
        }
        getPage(DownloadsPage.class).tapDeleteButton();
        getPage(DownloadsPage.class).tapConfirmDelete();
        softAssert.assertEquals(getPage(DownloadsPage.class).getHeaderText(), EMPTY_STATE_HEADER,
                "Video wasn't deleted");
        softAssert.assertAll();
    }
}
