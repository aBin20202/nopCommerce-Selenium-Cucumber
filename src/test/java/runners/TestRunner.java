package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by vuongphan on 04/27/2022 - - 11:06
 *
 * @project nopCommerce-Selenium-Cucumber
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions", "appHooks"},
        plugin = {
                "pretty", "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        dryRun = false,
        monochrome = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
