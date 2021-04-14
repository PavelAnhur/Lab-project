package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import com.epam.service.UsersManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.TimeoutException;

public class LoginWithEmailPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/email")
    private MobileElement emailButton;

    @AndroidFindBy(id = "org.coursera.android:id/password")
    private MobileElement passwordButton;

    @AndroidFindBy(id = "org.coursera.android:id/create_account")
    private MobileElement loginButton;

    @AndroidFindBy(id = "org.coursera.android:id/close_button")
    private MobileElement closeInformationButton;

    @AndroidFindBy(id = "org.coursera.android:id/find_course")
    private MobileElement findCourseButton;

    public void loginWithEmail(final String account) {
        String email;
        String password;
        switch (account) {
            case "Vlad":
                email = UsersManager.getUserEmailU().getEmail();
                password = UsersManager.getUserEmailU().getPassword();
                break;
            case "Pavel":
                email = UsersManager.getMobileUserPavel().getEmail();
                password = UsersManager.getMobileUserPavel().getPassword();
                break;
            case "Alex":
                email = UsersManager.getGoogleUser().getEmail();
                password = UsersManager.getGoogleUser().getPassword();
                break;
            default:
                email = UsersManager.getCourseraUser().getEmail();
                password = UsersManager.getCourseraUser().getPassword();
        }
        getLogger().info("input email: {}", email);
        WaitersService.waitForElementToBeClickable(getDriver(), emailButton);
        emailButton.sendKeys(email);
        getLogger().info("input password: {}", password);
        passwordButton.sendKeys(password);
        getLogger().info("click log in");
        try {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), loginButton).click();
            WaitersService.waitForVisibilityOfElement(getDriver(), findCourseButton);
        } catch (TimeoutException exception) {
            getLogger().warn("log in button wasn't tapped");
            loginButton.click();
            WaitersService.waitForVisibilityOfElement(getDriver(), findCourseButton);
        }
        getLogger().info("close information page");
        WaitersService.waitForElementToBeClickable(getDriver(), closeInformationButton);
        closeInformationButton.click();
    }
}
