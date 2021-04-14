package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.BottomSection;
import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.ExplorePage;
import com.epam.pages.mobile.coursera.InstructorPage;
import com.epam.pages.mobile.coursera.UniversityPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class UniversityReferenceStepDefs {
    private String universityNameFromLink;

    @When("the user clicks on the first course from the explore page")
    public void clickFirstCourseFromExplorePage() {
        getPage(BottomSection.class).navigateToExplore();
        getPage(ExplorePage.class).clickFirstCourseFromExplorePage();
        getPage(CoursePage.class).clickOnInstructor();
    }

    @When("the user clicks university website link")
    public void clickUniversityWebsiteLink() {
        universityNameFromLink = getPage(InstructorPage.class).getTextFromUniversityLink();
        getPage(InstructorPage.class).clickUniversityLink();
    }

    @Then("particular university page is opened")
    public void particularUniversityPageIsOpened() {
        Assert.assertTrue(getPage(UniversityPage.class).isParticularUniversityPageDisplayed(universityNameFromLink),
                "This is not " + universityNameFromLink + " page");
    }
}
