package com.epam.cucumber.steps;

import com.epam.pages.coursera.CourseraAccountSettingsPage;
import com.epam.pages.coursera.CourseraHomePage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.core.webdriver.factory.DriverManager.getDriver;
import static org.testng.Assert.assertTrue;

public class DeleteAccountStepDefs {

    private final CourseraHomePage homePage = new CourseraHomePage();
    private final CourseraAccountSettingsPage accountSettingsPage = new CourseraAccountSettingsPage();

    @When("clicks on delete account")
    public void clickOnDeleteAccount() {
        accountSettingsPage
                .clickDeleteAccountButton(UsersManager.getUserWithProfileProperties().getPassword());
        accountSettingsPage.selectAllCheckboxesInDeletingYourAccountWindow();
        accountSettingsPage
                .enterPasswordInDeletingYourAccountWindow(UsersManager.getUserWithProfileProperties().getPassword());
        accountSettingsPage.confirmDeleteYourAccount();
    }

    @Then("account should be deleted")
    public void accountShouldBeDeleted() {
        getDriver().navigate().refresh();
        assertTrue(homePage.isJoinForFreeDisplayed(), "Join for free isn't displayed");
    }
}
