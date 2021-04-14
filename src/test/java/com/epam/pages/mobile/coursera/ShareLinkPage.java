package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.SwipeService;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.WebElementsService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.Date;
import java.util.List;

public class ShareLinkPage extends BaseMobilePage {
    private static final int PRESS_TIME = 1000;

    @AndroidFindBy(id = "org.coursera.android:id/share")
    private MobileElement shareButton;

    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement justOnceButton;

    @AndroidFindBy(id = "com.google.android.apps.docs:id/upload_edittext_document_title")
    private MobileElement documentName;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement saveButton;

    @AndroidFindBy(id = "com.google.android.apps.docs:id/upload_folder")
    private MobileElement goToMyDriver;

    @AndroidFindBy(id = "com.google.android.apps.docs:id/entry_label")
    private List<MobileElement> filesNames;

    @AndroidFindBy(xpath = "//*[@class = 'android.widget.TextView' and contains(@text, '${dateForNewName}')]")
    private MobileElement lastFile;

    private String dateForNewName;

    public void clickShareButton() {
        getLogger().info("click share button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), shareButton).click();
    }

    public void clickJustOnceButton() {
        getLogger().info("click button just once");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), justOnceButton).click();
    }

    public void saveLinkToDrive() {
        dateForNewName = new Date().toString();
        WaitersService.waitForVisibilityOfElement(getDriver(), documentName);
        getLogger().info("clear name");
        documentName.clear();
        getLogger().info("named the file using current date");
        documentName.sendKeys(dateForNewName);
        getLogger().info("click button save");
        saveButton.click();
    }

    public void goToGoogleDrive() {
        clickShareButton();
        clickJustOnceButton();
        getLogger().info("go to my drive");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), goToMyDriver).click();
    }

    public boolean isCourseSharedToDrive() {
        SwipeService.swipeToElement(lastFile, PRESS_TIME);
        getLogger().info("get list of last saved files");
        List<String> nameFilesFromDrive = WebElementsService.getListOfWebElementsText(filesNames);
        getLogger().info("check is the link shared");
        return nameFilesFromDrive.contains(dateForNewName);
    }
}
