package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraChangeSubscriptionPlanPage;
import com.epam.pages.coursera.CourseraHelpCenterPage;
import com.epam.pages.coursera.CourseraPaymentsAndSubscriptionsPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SubscriptionPlanPageOpensSteps {
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraHelpCenterPage helpCenterPage = new CourseraHelpCenterPage();
    private final CourseraPaymentsAndSubscriptionsPage paymentsAndSubscriptionsPage =
            new CourseraPaymentsAndSubscriptionsPage();
    private final CourseraChangeSubscriptionPlanPage changePlanPage = new CourseraChangeSubscriptionPlanPage();

    @When("the user opens help center page")
    public void openHelpCenterPage() {
        userPage.goToHelpCenter();
    }

    @When("the user opens payments and subscriptions help center page")
    public void clickPaymentsButtonSwitchesToTab() {
        helpCenterPage.clickPaymentsButtonAndSwitchToNewTab();
    }

    @When("the user opens change subscription plan help center page")
    public void clickChangeSubscriptionPlanButton() {
        paymentsAndSubscriptionsPage.clickChangeSubscriptionPlanButton();
    }

    @Then("change subscription plan help center page header is {string}")
    public void verifyChangeSubscriptionPlanHelpCenterPageHeader(final String headerText) {
        Assert.assertEquals(changePlanPage.getHeaderText(), headerText, "Header text is incorrect");
    }
}
