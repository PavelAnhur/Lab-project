package com.epam.core.utilities.service;

import com.epam.core.webdriver.factory.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public final class TabsSwitcher {

    private TabsSwitcher() {
    }

    public static void switchToNewTab(final WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void switchBetweenTabs(final int tabIndex) {
        DriverManager.getDriver().switchTo()
                .window(new ArrayList<>(DriverManager.getDriver().getWindowHandles()).get(tabIndex));
    }

    public static void createNewTabAndSwitchToIt(final WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.open();");
        switchToNewTab(driver);
    }
}
