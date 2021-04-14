package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/profile_name_text")
    private MobileElement profileName;

    @AndroidFindBy(id = "org.coursera.android:id/profile_image")
    private MobileElement profileImage;

    @AndroidFindBy(id = "org.coursera.android:id/find_course")
    private MobileElement startLearningButton;

    @AndroidFindBy(id = "org.coursera.android:id/title_collapsing")
    private MobileElement headerProfile;

    public String getProfileName() {
        WaitersService.waitForVisibilityOfElement(getDriver(), profileName);
        String profile = profileName.getText();
        getLogger().info("get profile name: {}", profile);
        return profile;
    }

    public MobileElement getProfileImage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), profileImage);
        return profileImage;
    }

    public void clickStartLearningButton() {
        getLogger().info("Click start learning button");
        WaitersService.waitForElementToBeClickable(getDriver(), startLearningButton);
        startLearningButton.click();
    }

    public String getHeaderProfilePage() {
        WaitersService.waitForVisibilityOfElement(getDriver(), headerProfile);
        String header = headerProfile.getText();
        getLogger().info("get header name: {}", headerProfile.getText());
        return header;
    }
}
