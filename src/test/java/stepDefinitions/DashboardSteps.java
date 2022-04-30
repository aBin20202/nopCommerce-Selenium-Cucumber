package stepDefinitions;

import cucumber.BaseSteps;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.CustomerPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.Properties;

/**
 * Created by vuongphan on 04/27/2022 - - 12:13
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DashboardSteps extends BaseSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private DashboardPage dashboardPage;
    private CustomerPage customerPage;

    static Properties prop;

    private static String email = prop.getProperty("username") == null ? "admin@gmail.com" : System.getProperty("username");
    private static String password = System.getProperty("password") == null ? "Athen@southlane1" : System.getProperty("password");

//    @Given("user is on {string} page")
//    public void userIsOnDashboardPage(String pageName) {
//        navigateToLogin();
//        dashboardPage = loginPage.doLogin(email, password);
//        Assertions.assertThat(dashboardPage.getTitleHeader()).isEqualToIgnoringCase(pageName);
//    }

    @Given("user has already entered to {string} page")
    public void userHasAlreadyEnteredToDashboardPage(String pageName) {
        goToLoginPage();
        dashboardPage = loginPage.doLogin(email, password);
        Assertions.assertThat(dashboardPage.getTitleHeader()).isEqualToIgnoringCase(pageName);
    }

    @Given("user navigates to {string} page")
    public void userNavigatesToCustomerListPage() {
        customerPage = dashboardPage.selectMenu("Customers", "Customers");
    }

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        if (getPageTitle().contains("Login was unsuccessful.")) {
            Assertions.assertThat(false).isEqualTo(true);
        }
        Assertions.assertThat(getPageTitle()).isEqualToIgnoringCase(expectedTitle);
    }


}
