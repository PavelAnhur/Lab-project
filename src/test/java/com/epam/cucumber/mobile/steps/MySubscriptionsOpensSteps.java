package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.MySubscriptionsPage;
import com.epam.pages.mobile.coursera.SettingsSection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class MySubscriptionsOpensSteps {

    @And("the user opens my subscriptions page")
    public void openMySubscriptionsPage() {
        getPage(SettingsSection.class).openMySubscriptions();
    }

    @Then("my subscription page is opened, title name is {string}")
    public void verifyThatSubscriptionPageIsOpened(final String expectedName) {
        Assert.assertEquals(getPage(MySubscriptionsPage.class).getTitleText(), expectedName,
                "The page doesn't opened");
    }
}
