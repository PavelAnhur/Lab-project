package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class InstructorPage extends BaseMobilePage {

    @AndroidFindBy(xpath = "//*[@resource-id='org.coursera.android:id/partners']//*[@class='android.widget.TextView']")
    private MobileElement universityLink;

    public void clickUniversityLink() {
        getLogger().info("click on the university link");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), universityLink).click();
    }

    public String getTextFromUniversityLink() {
        WaitersService.waitForVisibilityOfElement(getDriver(), universityLink);
        String textFromLink = universityLink.getText();
        getLogger().info("text from the link: {}", textFromLink);
        return textFromLink;
    }
}
