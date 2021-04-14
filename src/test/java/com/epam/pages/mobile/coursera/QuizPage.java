package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class QuizPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/summative_quiz_begin_button")
    private MobileElement resumeButton;

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement title;

    @AndroidFindBy(id = "org.coursera.android:id/assignments_honor_code_continue_button")
    private MobileElement continueButton;

    public void tapResumeButton() {
        getLogger().info("tap resume button");
        WaitersService.waitForElementToBeClickable(getDriver(), resumeButton);
        resumeButton.click();
    }

    public String getTitleText(final String text) {
        WaitersService.waitUntilTextToBePresentInElement(getDriver(), title, text);
        return title.getText();
    }

    public void tapContinue() {
        getLogger().info("tap continue button");
        WaitersService.waitForElementToBeClickable(getDriver(), continueButton);
        continueButton.click();
    }
}
