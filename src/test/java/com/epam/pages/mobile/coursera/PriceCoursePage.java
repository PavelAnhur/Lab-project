package com.epam.pages.mobile.coursera;

import com.epam.core.mobile.base.page.BaseMobilePage;
import com.epam.core.utilities.service.WaitersService;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PriceCoursePage extends BaseMobilePage {
    private static final  String REGEX_PRICE = "\\$\\d+$|\\$\\d+\\.\\d\\d$|£\\d+$";

    @AndroidFindBy(id = "org.coursera.android:id/btn_join_course")
    private MobileElement subscribeButton;

    @AndroidFindBy(id = "org.coursera.android:id/subscription_price")
    private MobileElement price;

    public void goToPriceInformation() {
        getLogger().info("click subscribe button and go to price");
        WaitersService.waitForElementToBeClickableAndReturn(getDriver(), subscribeButton).click();
    }

    public boolean isPriceInformationTrue() {
        WaitersService.waitForVisibilityOfElement(getDriver(), price);
        Pattern patternPrice = Pattern.compile(REGEX_PRICE);
        Matcher matcherPrice = patternPrice.matcher(price.getText());
        return matcherPrice.find();
    }
}
