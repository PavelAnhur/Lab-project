package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UniversityPage extends BaseMobilePage {

    @AndroidFindBy(id = "org.coursera.android:id/partner_fullName")
    private MobileElement universityFullName;

    public boolean isParticularUniversityPageDisplayed(final String universityNameFromLink) {
        WaitersService.waitForVisibilityOfElement(getDriver(), universityFullName);
        String universityFullNameFromPageTitle = universityFullName.getText();
        getLogger().info("{} page is opened", universityFullNameFromPageTitle);
        return universityFullNameFromPageTitle.equals(universityNameFromLink);
    }
}
