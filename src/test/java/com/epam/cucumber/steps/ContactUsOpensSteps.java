package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraContactPage;
import com.epam.pages.coursera.CourseraHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactUsOpensSteps {
    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraContactPage contactPage = new CourseraContactPage();

    @When("the user opens Coursera website")
    public void openCourseraHomePage() {
        homePage.openPage();
    }

    @When("the user clicks contact button")
    public void clickContactUsButton() {
        homePage.scrollDownToBottom();
        homePage.clickContactButton();
    }

    @Then("contact us page is opened, page header is {string}")
    public void verifyContactUsPageHeader(final String headerText) {
        Assert.assertEquals(contactPage.getHeaderText(), headerText, "Header text is incorrect");
    }
}
