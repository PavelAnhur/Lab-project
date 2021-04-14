package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraBlogPage;
import com.epam.pages.coursera.CourseraHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlogSteps {
    private final CourseraBlogPage blogPage = new CourseraBlogPage();
    private final CourseraHomePage homePage = new CourseraHomePage();

    @When("the user goes to coursera blog")
    public void clickOnCourseraBlogLink() {
        homePage.clickCourseraBlogLink();
    }

    @Then("one hundred latest posts are in descending order")
    public void verifyOrderOfLatestPosts() {
        List<LocalDate> dateList = blogPage.getDatesOfLatestPostsAsListOfLocalDate();
        List<LocalDate> unsortedDateList = new ArrayList<>(dateList);
        dateList.sort(Collections.reverseOrder());
        Assert.assertEquals(unsortedDateList, dateList, "Dates are not in descending order");
    }
}
