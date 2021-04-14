package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckNotificationSteps {
    private final CourseraUserPage userPage = new CourseraUserPage();

    @When("the user opens notification")
    public void clickTheBellButton() {
        userPage.clickTheBellButton();
    }

    @Then("the text message {string} or {string} in notification is displayed")
    public void messageInNotificationIsDisplayed(final String noteContentEn, final String noteContentRu) {
        String realNoteContent = userPage.getNotificationContent();
        Assert.assertTrue(noteContentEn.equals(realNoteContent) || noteContentRu.equals(realNoteContent),
                "Notifications didn't view!");
        Assert.assertFalse(noteContentEn.isEmpty(), "Notifications didn't view!");
    }
}
