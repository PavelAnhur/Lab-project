package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraForStudentsPage;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.twitter.TweetPage;
import com.epam.pages.twitter.TwitterLogInPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class ShareToTwitterSteps {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraForStudentsPage forStudentsPage = new CourseraForStudentsPage();
    private final TwitterLogInPage twitterLogInPage = new TwitterLogInPage();
    private final TweetPage tweetPage = new TweetPage();

    @When("the user opens Coursera for students page")
    public void openCourseraForStudentsPage() {
        homePage.openPage();
        homePage.clickForStudentsButtonAndSwitchToNewTab();
    }

    @When("the user shares information to the twitter")
    public void shareInformationToTwitter() {
        forStudentsPage.clickShareButton();
        forStudentsPage.clickTwitterButtonAndSwitchToNewTab();
        twitterLogInPage.enterLoginAndPassword(UsersManager.getGoogleUser().getEmail(),
                UsersManager.getUserEmailU().getTwitterPassword());
        twitterLogInPage.clickSignInButton();
        try {
            twitterLogInPage.enterLoginAndPassword(UsersManager.getUserEmailU().getTwitterUserName(),
                    UsersManager.getUserEmailU().getTwitterPassword());
            twitterLogInPage.clickLogInButton();
        } catch (TimeoutException exception) {
            LOGGER.info("Login form wasn't shown again");
        }
    }

    @Then("tweet window with text that contains {string} is displayed")
    public void verifyTweetWindow(final String text) {
        Assert.assertTrue(tweetPage.getTweetText().contains(text) && tweetPage
                        .tweetWindowISDisplayed() && tweetPage.tweetButtonIsClickable(),
                "Tweet window is not displayed with needed text");
    }
}
