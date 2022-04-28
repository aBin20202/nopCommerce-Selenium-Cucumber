package cucumber;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.PropertyUtil;

import static factory.DriverFactory.getDriver;

/**
 * Created by vuongphan on 04/27/2022 - - 11:17
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class BaseSteps {

    public WebDriver driver = getDriver();


    public static PropertyUtil prop = new PropertyUtil();

    public LoginPage loginPage = new LoginPage(driver);
    public DashboardPage dashboardPage = new DashboardPage(driver);
    public CustomerPage customerPage = new CustomerPage(driver);

    private static final String host = prop.getProperty("host");

    public static LoginPage navigateToLogin() {
        getDriver().get(host + "/login");
        return new LoginPage(getDriver());
    }

    public DashboardPage goToDashboardPage() {
        driver.get(host + "/admin");
        return new DashboardPage(driver);
    }

    //Created for generating random string for Unique email
    public static String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }


}
