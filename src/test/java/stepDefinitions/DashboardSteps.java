package stepDefinitions;

import cucumber.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

/**
 * Created by vuongphan on 04/27/2022 - - 12:13
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DashboardSteps extends BaseSteps {

    @Then("Page Title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            Assertions.assertThat(false).isEqualTo(true);
        }
        Assertions.assertThat(driver.getTitle()).isEqualToIgnoringCase(expectedTitle);
    }

    @Given("user is on Dashboard page")
    public void userIsOnDashboardPage() {
        Assertions.assertThat(dashboardPage.getTitleHeader()).isEqualToIgnoringCase("Dashboard");
    }

    @When("user clicks on Customers Menu")
    public void userClicksOnCustomersMenu() {
        dashboardPage.clickOnCustomersMenu();
    }

    @And("click on Customers Menu Item")
    public void clickOnCustomersMenuItem() {
        dashboardPage.clickOnCustomersMenuItem();
    }


}
