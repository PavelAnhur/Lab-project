package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraForStudentsPage;
import com.epam.pages.coursera.CourseraUserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ListFrequentlyAskedForStudent {
    private final CourseraUserPage userPage = new CourseraUserPage();
    private final CourseraForStudentsPage courseraForStudentsPage = new CourseraForStudentsPage();

    @When("the user goes to coursera for student")
    public void goToCourseraForStudent() {
        userPage.goToCourseraForStudent();
    }

    @Then("the list of frequently asked questions is displayed on the page Coursera for student")
    public void checkListOfFrequentlyAskedQuestions() {
        Assert.assertTrue(courseraForStudentsPage.isListNotEmpty(), "The list of frequently asked questions is empty!");
    }
}
