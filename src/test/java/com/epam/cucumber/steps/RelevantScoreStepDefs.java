package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraCampusCoursematchPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class RelevantScoreStepDefs {

    private final CourseraCampusCoursematchPage coursematchPage = new CourseraCampusCoursematchPage();

    @Then("elements form relevant score collum are in descending order")
    public void areElementsFromRelevantScoreInDescendingOrder() {
        Assert.assertTrue(coursematchPage.areElementsFromRelevantScoreInDescendingOrder(),
                "Values from relevant score column of the table are not in descending order!");
    }
}
