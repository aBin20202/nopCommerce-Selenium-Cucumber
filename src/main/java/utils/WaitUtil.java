package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static factory.DriverFactory.getDriver;

/**
 * Created by vuongphan on 04/20/2022 - - 11:58
 *
 * @project appium-cucumber-testng-parallel-demo
 */
public class WaitUtil {

    protected static WebDriverWait wait;
    private static final int defaultTimeout = 10;

    public static WebElement waitForElementVisible(WebElement element) {
        return waitForElementVisible(element, defaultTimeout);
    }

    public static WebElement waitForElementVisible(WebElement element, int timeout) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementClickable(WebElement element) {
        return waitForElementClickable(element, defaultTimeout);
    }

    public static WebElement waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

}
