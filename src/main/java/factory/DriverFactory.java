package factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import utils.PropertyUtil;

import java.time.Duration;
import java.util.Date;


/**
 * Created by vuongphan on 04/27/2022 - - 11:07
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private static final PropertyUtil prop = new PropertyUtil();


    public void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }

    public WebDriver initDriver() {
        String browser = System.getProperty("browser", "chrome");
        String threadName = Thread.currentThread().getName();
        long threadId = Thread.currentThread().getId();
        System.out.println("Thread name & browser name: " + threadName + " --> " + browser);
        System.out.println("Thread id & browser name: " + threadId + " --> " + browser);
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = DriverOptions.getChromeOptions();
                setDriver(new ChromeDriver(Boolean.getBoolean("isJenkinsEnv") ?
                        options.setBinary("/usr/bin/google-chrome") : options));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                setDriver(new FirefoxDriver());
                break;
            case "safari":
                setDriver(new SafariDriver());
            default:
                throw new RuntimeException("Unsupported browser name: " + browser);
        }
        getDriver().manage().window().setSize(new Dimension(1300, 760));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))))
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeoutInSecond"))));
        System.out.println("------------- Started the " + browser + " browser -------------");
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }


    public void stopDriver() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
                System.out.println("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("------------- Can not close the browser with error " + e.getMessage() + " -------------");
        }
    }

    public void analyzeLog() {
        LogEntries logEntries = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

}
