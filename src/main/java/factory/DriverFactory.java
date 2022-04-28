package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import utils.PropertyUtil;

import java.time.Duration;

/**
 * Created by vuongphan on 04/27/2022 - - 11:07
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DriverFactory {
    public static WebDriver driver;

    private static final PropertyUtil prop = new PropertyUtil();

    public static WebDriver getDriver() {
        if (driver == null) driver = init_driver();
        return driver;
    }

    public static WebDriver init_driver() {

        String browser = System.getProperty("browser", "chrome");
        System.out.println("browser value is: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = DriverOptions.getChromeOptions();
                driver = new ChromeDriver(Boolean.getBoolean("isJenkinsEnv") ?
                        options.setBinary("/usr/bin/google-chrome") : options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
            default:
                throw new RuntimeException("Unsupported browser name: " + browser);
        }
        driver.manage().window().setSize(new Dimension(1300, 760));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))))
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeoutInSecond"))));
        System.out.println("------------- Started the " + browser + " browser -------------");
        return driver;
    }

    public static void quitDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                System.out.println("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            System.out.println("------------- Can not close the browser with error " + e.getMessage() + " -------------");
        }
    }
}
