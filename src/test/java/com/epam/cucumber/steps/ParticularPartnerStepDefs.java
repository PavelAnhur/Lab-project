package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraHomePage;
import com.epam.pages.coursera.CourseraPartnersPage;
import com.epam.pages.coursera.CourseraRuPartnersPage;
import com.epam.pages.coursera.CourseraYandexCoursesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ParticularPartnerStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraPartnersPage partnersPage = new CourseraPartnersPage();
    private final CourseraRuPartnersPage ruPartnersPage = new CourseraRuPartnersPage();
    private final CourseraYandexCoursesPage yandexCoursesPage = new CourseraYandexCoursesPage();

    @Given("the user opens partners page")
    public void openPartnersPage() {
        homePage.openPage();
        homePage.clickPartnersLink();
    }

    @When("the user selects Big data applications course by Yandex")
    public void selectYandexCourse() {
        partnersPage.getRussianPartners();
        ruPartnersPage.clickYandexButton();
        yandexCoursesPage.selectBigDataApplicationsCourse();
    }

    @Then("the course is offered by {string}")
    public void isCourseOfferedByPartner(final String partner) {
        Assert.assertEquals(yandexCoursesPage.getPartnerTitleValue(), partner,
                "This course isn't offered by " + partner + "!");
    }

    @Then("partners number should be equal to number of partners logos")
    public void verifyPartnersNumberWithNumberOfPartnersLogos() {
        Assert.assertEquals(partnersPage.getPartnersNumber(), partnersPage.getNumberOfPartnersLogos(),
                "Partners number and number of partners logos are not equals");
    }
}
