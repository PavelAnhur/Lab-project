package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.CoursePage;
import com.epam.pages.mobile.coursera.RefundPolicyPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class RefundPolicyStepDefs {

    @When("clicks on refund policy link")
    public void clicksRefundPolicyLink() {
        getPage(CoursePage.class).clickSpecializationLink();
        getPage(CoursePage.class).clickRefundPolicyLink();
    }

    @Then("page's header equals {string}")
    public void doesPageHeaderContainText(final String header) {
        Assert.assertEquals(header, getPage(RefundPolicyPage.class).getPageHeaderText(),
                "Page header not equal: " + header);
    }
}
