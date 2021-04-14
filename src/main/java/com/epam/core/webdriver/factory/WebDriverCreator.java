package com.epam.core.webdriver.factory;

import com.epam.core.utilities.property.PropertyDataReader;
import com.epam.core.webdriver.decorator.WebDriverDecorator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public final class WebDriverCreator {
    private static final String VIRTUAL_URL = "http://10.6.217.135:4444/wd/hub";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String BROWSER_NAME = "browserName";

    private WebDriverCreator() {
    }

    public static WebDriver setupWebDriver() {
        String property = System.getProperty("browser");
        WebDriver driver;
        if (property != null) {
            driver = selectBrowserForWebDriverSetUp(property);
        } else {
            Properties properties = PropertyDataReader.getProperties(System.getenv("environment"));
            driver = selectBrowserForWebDriverSetUp(properties.getProperty("browser"));
        }
        driver.manage().window().maximize();
        return new WebDriverDecorator(driver);
    }

    private static WebDriver selectBrowserForWebDriverSetUp(final String key) {
        WebDriver driver = null;
        switch (key) {
            case "remoteChrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(BROWSER_NAME, BrowserType.CHROME);
                try {
                    driver = new RemoteWebDriver(new URL(VIRTUAL_URL), chromeOptions);
                } catch (MalformedURLException e) {
                    LOGGER.error(e.getMessage());
                }
                break;
            case "remoteOpera":
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setCapability(BROWSER_NAME, BrowserType.OPERA_BLINK);
                try {
                    driver = new RemoteWebDriver(new URL(VIRTUAL_URL), operaOptions);
                } catch (MalformedURLException e) {
                    LOGGER.error(e.getMessage());
                }
                break;
            case "remoteFirefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(BROWSER_NAME, BrowserType.FIREFOX);
                try {
                    driver = new RemoteWebDriver(new URL(VIRTUAL_URL), firefoxOptions);
                } catch (MalformedURLException e) {
                    LOGGER.error(e.getMessage());
                }
                break;
            case "remoteEdge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(BROWSER_NAME, BrowserType.EDGE);
                try {
                    driver = new RemoteWebDriver(new URL(VIRTUAL_URL), edgeOptions);
                } catch (MalformedURLException e) {
                    LOGGER.error(e.getMessage());
                }
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", "en");
                FirefoxOptions firefoxOptionsLocal = new FirefoxOptions();
                firefoxOptionsLocal.setProfile(profile);
                driver = new FirefoxDriver(firefoxOptionsLocal);
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }
}
