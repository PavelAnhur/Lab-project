package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class ProfileSteps {
    private final SoftAssert softAssert = new SoftAssert();

    @Then("the user can see profile image")
    public void verifyProfileImage() {
        Assert.assertTrue(getPage(ProfilePage.class).getProfileImage().isDisplayed());
    }

    @When("the user opens profile")
    public void opensProfile() {
        getPage(BottomSection.class).navigateToProfile();
    }

    @Then("the user can see {string} username")
    public void verifyUsername(final String username) {
        Assert.assertEquals(getPage(ProfilePage.class).getProfileName(), username);
    }

    @Then("the user can see page with the header {string} and {string} username")
    public void checkPageHeaderAndUserName(final String headerName, final String userName) {
        softAssert.assertEquals(headerName, getPage(ProfilePage.class).getHeaderProfilePage(),
                "Probably, user didn't open profile");
        softAssert.assertTrue(userName.contains(getPage(ProfilePage.class).getProfileName()),
                "User didn't open profile!");
        softAssert.assertAll();
    }
}
