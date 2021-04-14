package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DownloadsPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/course_name")
    private MobileElement courseName;

    @AndroidFindBy(accessibility = "Delete")
    private MobileElement deleteButton;

    @AndroidFindBy(id = "org.coursera.android:id/positive_button")
    private MobileElement confirmationDeleteButton;

    @AndroidFindBy(id = "org.coursera.android:id/empty_state_header")
    private MobileElement emptyStateHeader;

    public String getCourseName() {
        getLogger().info("receiving course name");
        WaitersService.waitForVisibilityOfElement(getDriver(), courseName);
        return courseName.getText();
    }

    public void tapDeleteButton() {
        getLogger().info("tap delete button");
        WaitersService.waitForElementToBeClickable(getDriver(), deleteButton);
        deleteButton.click();
    }

    public void tapConfirmDelete() {
        getLogger().info("tap confirm delete");
        WaitersService.waitForElementToBeClickable(getDriver(), confirmationDeleteButton);
        confirmationDeleteButton.click();
    }

    public String getHeaderText() {
        getLogger().info("get header text");
        WaitersService.waitForVisibilityOfElement(getDriver(), emptyStateHeader);
        return emptyStateHeader.getText();
    }
}
