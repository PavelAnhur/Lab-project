package com.epam.cucumber.mobile.steps;

import com.epam.cucumber.mobile.commonData.SharingData;
import com.epam.pages.mobile.coursera.LoginPage;
import com.epam.pages.mobile.coursera.LoginWithEmailPage;
import com.epam.service.UsersManager;
import io.cucumber.java.en.Given;

import static com.epam.cucumber.mobile.reflection.PageManager.getPage;

public class LoginStepDefs {
    private static final String KEY = "email";
    private final SharingData sharingData;

    public LoginStepDefs(final SharingData data) {
        this.sharingData = data;
    }

    @Given("the user enters {string} credentials at the login page")
    public void enterAccountCredentials(final String account) {
        getPage(LoginPage.class).goToLoginWithEmailPage();
        getPage(LoginWithEmailPage.class).loginWithEmail(account);
        sharingData.addDataToMap(KEY, getAccountEmail(account));
    }

    private String getAccountEmail(final String account) {
        String email;
        switch (account) {
            case "Pavel":
                email = UsersManager.getMobileUserPavel().getEmail();
                break;
            case "Vlad":
                email = UsersManager.getUserEmailU().getEmail();
                break;
            case "Alex":
                email = UsersManager.getGoogleUser().getEmail();
                break;
            default:
                email = UsersManager.getCourseraUser().getEmail();
        }
        return email;
    }
}
