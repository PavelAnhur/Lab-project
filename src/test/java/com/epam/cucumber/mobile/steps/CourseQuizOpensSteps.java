package com.epam.cucumber.mobile.steps;

import com.epam.pages.mobile.coursera.LearnPage;
import com.epam.pages.mobile.coursera.PhotoCoursePage;
import com.epam.pages.mobile.coursera.QuizPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class CourseQuizOpensSteps {

    @When("the user opens course quiz")
    public void openCourseQuiz() {
        getPage(LearnPage.class).openCourseHomePage();
        getPage(PhotoCoursePage.class).openQuiz();
    }

    @Then("the quiz is opened, title with text {string} is presented")
    public void theQuizIsOpened(final String expectedText) {
        getPage(QuizPage.class).tapResumeButton();
        getPage(QuizPage.class).tapContinue();
        Assert.assertEquals(getPage(QuizPage.class).getTitleText(expectedText), expectedText,
                "The quiz wasn't opened");
    }
}
