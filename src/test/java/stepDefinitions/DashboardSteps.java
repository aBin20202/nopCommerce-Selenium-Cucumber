package stepDefinitions;

import cucumber.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

/**
 * Created by vuongphan on 04/27/2022 - - 12:13
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DashboardSteps extends BaseSteps {

    private static String email = prop.getProperty("username");
    private static String password = prop.getProperty("password");

    @Given("user is on {string} page")
    public void userIsOnDashboardPage(String pageName) {
        navigateToLogin();
        if (email == null) {
            email = "admin@gmail.com";
        }
        if (password == null) {
            password = "Admin";
        }
        dashboardPage = loginPage.doLogin(email, password);
        Assertions.assertThat(dashboardPage.getTitleHeader()).isEqualToIgnoringCase(pageName);
    }


    @Given("user is on Customer list page")
    public void userIsOnCustomerListPage() {
        customerPage = dashboardPage.selectMenu("Customers", "Customers");

    }


    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assertions.assertThat(false).isEqualTo(true);
        }
        Assertions.assertThat(driver.getTitle()).isEqualToIgnoringCase(expectedTitle);
    }


}
