package com.epam.core.webdriver.decorator;

import com.epam.core.utilities.service.WaitersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.WrapsDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverDecorator implements WebDriver, JavascriptExecutor, Window, ImeHandler, Navigation,
        TargetLocator, Timeouts, Options, TakesScreenshot, WrapsDriver {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private final WebDriver driver;

    public WebDriverDecorator(final WebDriver webDriver) {
        this.driver = webDriver;
    }

    @Override
    public void get(final String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(final By by) {
        LOGGER.trace("finding elements {}, on page {}", by.toString(), driver.getCurrentUrl());
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(final By by) {
        LOGGER.trace("finding element {}, on page {}", by.toString(), driver.getCurrentUrl());
        return WaitersService.waitUntilPresenceOfElementAndReturn(driver, by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        LOGGER.trace("close driver");
        driver.close();
    }

    @Override
    public void quit() {
        LOGGER.trace("quit driver");
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public WebDriver.Options manage() {
        return driver.manage();
    }

    @Override
    public Object executeScript(final String s, final Object... objects) {
        LOGGER.trace("executing script {}", s);
        return ((JavascriptExecutor) driver).executeScript(s, objects);
    }

    @Override
    public Object executeAsyncScript(final String s, final Object... objects) {
        LOGGER.trace("executing async script {}", s);
        return ((JavascriptExecutor) driver).executeAsyncScript(s, objects);
    }

    @Override
    public void setSize(final Dimension dimension) {
        driver.manage().window().setSize(dimension);
    }

    @Override
    public void setPosition(final Point point) {
        driver.manage().window().setPosition(point);
    }

    @Override
    public Dimension getSize() {
        return driver.manage().window().getSize();
    }

    @Override
    public Point getPosition() {
        return driver.manage().window().getPosition();
    }

    @Override
    public void maximize() {
        driver.manage().window().maximize();
    }

    @Override
    public void fullscreen() {
        driver.manage().window().fullscreen();
    }

    @Override
    public List<String> getAvailableEngines() {
        return driver.manage().ime().getAvailableEngines();
    }

    @Override
    public String getActiveEngine() {
        return driver.manage().ime().getActiveEngine();
    }

    @Override
    public boolean isActivated() {
        return driver.manage().ime().isActivated();
    }

    @Override
    public void deactivate() {
        driver.manage().ime().deactivate();
    }

    @Override
    public void activateEngine(final String s) {
        driver.manage().ime().activateEngine(s);
    }

    @Override
    public void back() {
        driver.navigate().back();
    }

    @Override
    public void forward() {
        driver.navigate().forward();
    }

    @Override
    public void to(final String s) {
        driver.navigate().to(s);
    }

    @Override
    public void to(final URL url) {
        driver.navigate().to(url);
    }

    @Override
    public void refresh() {
        driver.navigate().refresh();
    }

    @Override
    public WebDriver frame(final int i) {
        return driver.switchTo().frame(i);
    }

    @Override
    public WebDriver frame(final String s) {
        return driver.switchTo().frame(s);
    }

    @Override
    public WebDriver frame(final WebElement webElement) {
        return driver.switchTo().frame(webElement);
    }

    @Override
    public WebDriver parentFrame() {
        return driver.switchTo().parentFrame();
    }

    @Override
    public WebDriver window(final String s) {
        return driver.switchTo().window(s);
    }

    @Override
    public WebDriver defaultContent() {
        return driver.switchTo().defaultContent();
    }

    @Override
    public WebElement activeElement() {
        return driver.switchTo().activeElement();
    }

    @Override
    public Alert alert() {
        return driver.switchTo().alert();
    }

    @Override
    public Timeouts implicitlyWait(final long l, final TimeUnit timeUnit) {
        return driver.manage().timeouts().implicitlyWait(l, timeUnit);
    }

    @Override
    public Timeouts setScriptTimeout(final long l, final TimeUnit timeUnit) {
        return driver.manage().timeouts().setScriptTimeout(l, timeUnit);
    }

    @Override
    public Timeouts pageLoadTimeout(final long l, final TimeUnit timeUnit) {
        return driver.manage().timeouts().pageLoadTimeout(l, timeUnit);
    }

    @Override
    public void addCookie(final Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    @Override
    public void deleteCookieNamed(final String s) {
        driver.manage().deleteCookieNamed(s);
    }

    @Override
    public void deleteCookie(final Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    @Override
    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    @Override
    public Set<Cookie> getCookies() {
        return driver.manage().getCookies();
    }

    @Override
    public Cookie getCookieNamed(final String s) {
        return driver.manage().getCookieNamed(s);
    }

    @Override
    public Timeouts timeouts() {
        return driver.manage().timeouts();
    }

    @Override
    public ImeHandler ime() {
        return driver.manage().ime();
    }

    @Override
    public Window window() {
        return driver.manage().window();
    }

    @Override
    public Logs logs() {
        return driver.manage().logs();
    }

    @Override
    public <X> X getScreenshotAs(final OutputType<X> outputType) throws WebDriverException {
        return ((TakesScreenshot) driver).getScreenshotAs(outputType);
    }

    @Override
    public WebDriver getWrappedDriver() {
        return driver;
    }
}
