package appHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TakeScreenshotUtil;

import static factory.DriverFactory.getDriver;

/**
 * Created by vuongphan on 04/27/2022 - - 12:10
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class HookSteps {
    @Before(order = 1)
    public void lauchDriver() {
        DriverFactory.init_driver();
    }

    @After(order = 0)
    public void quitApplication() {
        DriverFactory.quitDriver();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakeScreenshotUtil.takeScreenShotFailureScenario(getDriver(), scenario.getName());
        } else TakeScreenshotUtil.takeScreenshot(getDriver(), scenario.getName(), getClass());
    }
}
