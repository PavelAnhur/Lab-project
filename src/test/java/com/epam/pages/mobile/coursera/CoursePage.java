package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.StringService;
import com.epam.core.utilities.service.SwipeService;
import com.epam.core.utilities.service.WaitersService;
import com.epam.core.utilities.service.MobileElementsService;
import com.epam.core.utilities.service.WebElementsService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class CoursePage extends BaseMobilePage {
    private static final double LINK_Y_OFFSET_RATIO = 0.97;
    private static final int PRESS_TIME = 1000;
    private static final double X_OFFSET_RATIO_FOR_TABLET = 0.3;
    private static final double X_OFFSET_RATIO_FOR_PHONES = 0.21;
    private static final String COMMAND_LINE_ARGUMENT = "env";
    private static final String DEVICE_NAME = "pixel-2-ver10";

    @AndroidFindBy(id = "org.coursera.android:id/xdp_outline")
    private MobileElement courseView;

    @AndroidFindBy(id = "org.coursera.android:id/ratings_info")
    private MobileElement ratingInfo;

    @AndroidFindBy(id = "org.coursera.android:id/instructor_photo")
    private MobileElement instructorView;

    @AndroidFindBy(id = "org.coursera.android:id/fin_aid")
    private MobileElement financialAid;

    @AndroidFindBy(id = "org.coursera.android:id/positive_button")
    private MobileElement confirmApplyButton;

    @AndroidFindBy(id = "org.coursera.android:id/element_description")
    private MobileElement specializationLink;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What is the refund policy?\")")
    private MobileElement refundPolicySpan;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"See our full refund policy\")")
    private MobileElement refundPolicyLink;

    @AndroidFindBy(id = "org.coursera.android:id/toolbar_title")
    private MobileElement toolbarTitle;

    @AndroidFindBy(id = "org.coursera.android:id/share")
    private MobileElement shareButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Gmail\")")
    private MobileElement gMailButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Just\")")
    private MobileElement justOnceButton;

    public void clickOnInstructor() {
        getLogger().info("click on the instructor of the course");
        SwipeService.swipeToElement(instructorView, PRESS_TIME);
        instructorView.click();
    }

    public String getRatingInfo() {
        WaitersService.waitForVisibilityOfElement(getDriver(), ratingInfo);
        String courseRatingInfo = StringService.getFirstWordFromString(ratingInfo.getText(), " ");
        getLogger().info("course rating from course page: {}", courseRatingInfo);
        return courseRatingInfo;
    }

    public void clickFinancialAid() {
        getLogger().info("click on the financial aid available");
        WaitersService.waitForVisibilityOfElement(getDriver(), courseView);
        SwipeService.swipeToElement(financialAid, PRESS_TIME);
        financialAid.click();
    }

    public void confirmApply() {
        getLogger().info("confirm apply");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), confirmApplyButton).click();
    }

    public void clickSpecializationLink() {
        getLogger().info("click on specialization link in the course info");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), specializationLink).click();
    }

    public void clickRefundPolicyLink() {
        getLogger().info("click on 'What is refund policy?' span");
        SwipeService.swipeToElement(refundPolicySpan, PRESS_TIME);
        refundPolicySpan.click();
        getLogger().info("click 'see our full refund policy' link");
        WaitersService.waitForElementToBeClickable(getDriver(), refundPolicyLink);
        SwipeService.checkElementPositionOnPage(refundPolicyLink, PRESS_TIME);
        MobileElementsService.clickLinkInsideElement(refundPolicyLink, getXOffsetRatio(), LINK_Y_OFFSET_RATIO);
    }

    public boolean doesSearchResultContainParticularCourse(final String searchTerm) {
        String courseNameFromSearchTerm = getCourseNameFromSearchResult();
        getLogger().info("open {} page", courseNameFromSearchTerm);
        getLogger().info("search result contains {} ", searchTerm);
        return StringService.getNumberOfEqualWordsInStrings(searchTerm, getCourseNameFromSearchResult()) > 0;
    }

    private String getCourseNameFromSearchResult() {
        WaitersService.waitForVisibilityOfElement(getDriver(), toolbarTitle);
        return toolbarTitle.getText();
    }

    public void clickShareButton() {
        getLogger().info("click share button");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), shareButton).click();
    }

    public void shareWithGmail() {
        getLogger().info("click share with Gmail");
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals(DEVICE_NAME)) {
            WaitersService.waitForElementToBeClickableAndReturn(getDriver(), gMailButton).click();
        }
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), gMailButton).click();
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), justOnceButton).click();
        WebElementsService.closeUpdateForm();
    }

    private double getXOffsetRatio() {
        if (System.getProperty(COMMAND_LINE_ARGUMENT).equals("pixel-c")) {
            return X_OFFSET_RATIO_FOR_TABLET;
        }
        return X_OFFSET_RATIO_FOR_PHONES;
    }
}
