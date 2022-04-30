package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

/**
 * Created by vuongphan on 04/27/2022 - - 11:06
 *
 * @project nopCommerce-Selenium-Cucumber
 */
@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = {"stepDefinitions", "appHooks"},
        plugin = {
                "pretty", "json:target/JsonReport/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"

        },
        publish = false,
        dryRun = false,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


    @BeforeSuite
    public void testSetup() {
//        System.setProperty("host", "https://virginia-beach.etstack.io");
//        System.setProperty("username", "ath-virginia-beach@edulog.com");
//        System.setProperty("password", "Athen@virginia-beach1");
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("After Suite");

    }


}
