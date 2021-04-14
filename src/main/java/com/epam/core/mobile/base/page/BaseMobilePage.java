package com.epam.core.mobile.base.page;

import com.epam.core.mobile.driver.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BaseMobilePage {
    private static final int PAUSE_TIME = 4000;
    private final AndroidDriver<MobileElement> driver;
    private final Logger logger;
    private final Actions actions;
    private final TouchAction touchAction;

    public BaseMobilePage() {
        driver = MobileDriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        actions = new Actions(driver);
        touchAction = new TouchAction(driver);
        logger = LogManager.getRootLogger();
    }

    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }

    public static int getPauseTime() {
        return PAUSE_TIME;
    }

    public Actions getActions() {
        return actions;
    }

    public TouchAction getTouchAction() {
        return touchAction;
    }

    public void getBack() {
        logger.info("get back");
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
