package com.epam.cucumber.mobile.steps;

import com.epam.core.enums.Context;
import com.epam.core.utilities.service.ContextSwitcher;
import com.epam.cucumber.mobile.commonData.SharingData;
import com.epam.pages.mobile.coursera.FacebookLoginPage;
import com.epam.pages.mobile.coursera.LoginPage;
import io.cucumber.java.en.When;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class FacebookLoginStepDefs {
    private static final String KEY = "email";
    private final SharingData sharingData;

    public FacebookLoginStepDefs(final SharingData data) {
        this.sharingData = data;
    }

    @When("the user clicks continue with Facebook button")
    public void clickContinueWithFacebookButton() {
        getPage(LoginPage.class).clickFacebookButton();
    }

    @When("the user enters {string} in the email input field")
    public void enterEmail(final String email) {
        getPage(FacebookLoginPage.class).inputEmail(email);
        sharingData.addDataToMap(KEY, email);
    }

    @When("enters {string} in the password input field")
    public void enterPassword(final String password) {
        getPage(FacebookLoginPage.class).inputPassword(password);
        getPage(FacebookLoginPage.class).clickConfirmButton();
        ContextSwitcher.switchContext(Context.NATIVE.getContextName());
        getPage(LoginPage.class).clickFindCourseButton();
    }
}
