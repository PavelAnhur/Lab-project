package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.MobileElementsService;
import com.epam.core.utilities.service.StringService;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateAccountPage extends BaseMobilePage {
    private static final int STRING_LENGTH = 8;
    private String fullName;

    @AndroidFindBy(id = "org.coursera.android:id/full_name")
    private MobileElement fullNameField;

    @AndroidFindBy(id = "org.coursera.android:id/email")
    private MobileElement emailField;

    @AndroidFindBy(id = "org.coursera.android:id/password")
    private MobileElement passwordField;

    @AndroidFindBy(id = "org.coursera.android:id/create_account")
    private MobileElement createAccountButton;

    @AndroidFindBy(id = "org.coursera.android:id/onboarding_page_header")
    private MobileElement onboardingPageHeader;

    public String getFullName() {
        return fullName;
    }

    public void inputFullName() {
        fullName = StringService.getRandomString(STRING_LENGTH);
        getLogger().info("input {} in full name field", fullName);
        WaitersService.waitForVisibilityOfElement(getDriver(), fullNameField);
        fullNameField.sendKeys(fullName);
    }

    public void inputEmail() {
        String email = fullName + "@gmail.com";
        getLogger().info("input {} in email field", email);
        emailField.sendKeys(email);
    }

    public void inputPassword() {
        String password = StringService.getRandomString(STRING_LENGTH);
        getLogger().info("input {} in password field", password);
        passwordField.sendKeys(password);
    }

    public void clickCreateAccountButton() {
        getLogger().info("click create account button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), createAccountButton).click();
        MobileElementsService.closeSavePasswordForm();
        WaitersService.waitForVisibilityOfElement(getDriver(), onboardingPageHeader);
        getBack();
    }
}
