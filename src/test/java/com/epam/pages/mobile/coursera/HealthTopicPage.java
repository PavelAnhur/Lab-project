package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class HealthTopicPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/card_title")
    private List<MobileElement> degreeTitles;

    @AndroidFindBy(accessibility = "See All Earn Your Degree")
    private MobileElement seeAllButton;

    public void tapSeeAllButton() {
        WaitersService.waitForElementToBeClickable(getDriver(), seeAllButton);
        getLogger().info("Tap see all button");
        seeAllButton.click();
    }

    public void tapDegreeTitleByName(final String titleName) {
        getLogger().info("Open {} course", titleName);
        WaitersService.waitUntilVisibilityOfAllElements(getDriver(), degreeTitles);
        for (MobileElement course: degreeTitles) {
            if (course.getText().contains(titleName)) {
                getTouchAction().tap(element(course)).perform();
                break;
            }
        }
    }
}
