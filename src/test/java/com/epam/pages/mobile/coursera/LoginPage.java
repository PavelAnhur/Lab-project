package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/fb_text")
    private MobileElement facebookButton;

    @AndroidFindBy(id = "org.coursera.android:id/createAccount")
    private MobileElement createAccountButton;

    @AndroidFindBy(id = "org.coursera.android:id/text")
    private MobileElement googleButton;

    @AndroidFindBy(id = "com.google.android.gms:id/account_particle_disc")
    private MobileElement accountToUse;

    @AndroidFindBy(id = "org.coursera.android:id/find_course")
    private MobileElement findCourseButton;

    @AndroidFindBy(id = "org.coursera.android:id/close_button")
    private MobileElement signupLaterButton;

    @AndroidFindBy(id = "org.coursera.android:id/offline_text")
    private MobileElement noConnection;

    @AndroidFindBy(id = "org.coursera.android:id/login")
    private MobileElement logInWithEmailButton;

    public void loginWithGoogleAccount() {
        getLogger().info("login with google account");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), googleButton).click();
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), accountToUse).click();
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), findCourseButton).click();
    }

    public void clickCreateAccountButton() {
        getLogger().info("click create account button");
        WaitersService.waitForElementToBeClickable(getDriver(), createAccountButton);
        createAccountButton.click();
    }

    public void clickFacebookButton() {
        getLogger().info("click continue with Facebook");
        WaitersService.waitForElementToBeClickable(getDriver(), facebookButton);
        facebookButton.click();
    }

    public void signupLater() {
        getLogger().info("sign up later");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), signupLaterButton).click();
    }

    public MobileElement getGoogleButton() {
        WaitersService.waitForElementToBeClickable(getDriver(), googleButton);
        return googleButton;
    }

    public String getNoConnectionText() {
        String connection = noConnection.getText();
        getLogger().info("connection message: {}", connection);
        return connection;
    }

    public void goToLoginWithEmailPage() {
        getLogger().info("open login with email");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), logInWithEmailButton).click();
    }

    public boolean isSignupDisplayed() {
        getLogger().info("check sign up button");
        WaitersService.waitForVisibilityOfElement(getDriver(), signupLaterButton);
        return signupLaterButton.isDisplayed();
    }

    public void clickFindCourseButton() {
        getLogger().info("click find course button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), findCourseButton).click();
    }
}
