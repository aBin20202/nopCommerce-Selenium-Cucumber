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

    private static final PropertyUtil prop = new PropertyUtil();

    private String host = prop.getProperty("host");

    public LoginPage goToLoginPage() {
        getDriver().get(host + "/login");
        return new LoginPage(driver);
    }

    public DashboardPage goToDashboardPage() {
        getDriver().get(host + "/admin");
        return new DashboardPage(getDriver());
    }

    //Created for generating random string for Unique email
    public static String randomString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }


}
