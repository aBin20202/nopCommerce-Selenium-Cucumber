package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Created by vuongphan on 04/29/2022 - - 11:38
 *
 * @project nopCommerce-Selenium-Cucumber
 */
//@CucumberOptions(
//        features = "src/test/resources/features/Login.feature",
//        glue = {"stepDefinitions", "appHooks"},
//        plugin = {
//                "pretty", "html:target/cucumber-reports/cucumber.html",
//                "json:target/cucumber-reports/cucumber.json",
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//                "timeline:test-output-thread/"
//
//        },
//        dryRun = false,
//        monochrome = true
//
//)
//public class ParallelTest extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//}
