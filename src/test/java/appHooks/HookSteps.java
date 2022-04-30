package appHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by vuongphan on 04/27/2022 - - 12:10
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class HookSteps {
    private DriverFactory driverFactory;
    private WebDriver driver;


    @Before(order = 1)
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();
//        driverFactory.analyzeLog();
    }

    @After(order = 0)
    public void quitDriver() {
        driver.quit();
    }

//    @After(order = 1)
//    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            TakeScreenshotUtil.takeScreenShotFailureScenario(driver, scenario.getName());
//        } else TakeScreenshotUtil.takeScreenshot(driver, scenario.getName(), getClass());
//    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png", screenshotName);
    }
}
