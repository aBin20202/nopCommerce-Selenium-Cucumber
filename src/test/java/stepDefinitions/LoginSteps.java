package stepDefinitions;

import cucumber.BaseSteps;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.LoginPage;

/**
 * Created by vuongphan on 04/27/2022 - - 11:00
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class LoginSteps extends BaseSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        goToLoginPage();
    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
    }

    @Then("verify that page title should be {string}")
    public void verifyThatPageTitleShouldBe(String expectedTitle) {
        if (getPageTitle().contains("Login was unsuccessful.")) {
            Assertions.assertThat(false).isEqualTo(true);
        }
        Assertions.assertThat(getPageTitle()).isEqualToIgnoringCase(expectedTitle);
    }

    @And("user enters Email as {string} and Password as {string}")
    public void userEntersEmailAsAndPasswordAs(String email, String password) {
        loginPage.setEmail(email)
                .setPassword(password);
    }

    @And("click on Login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLogin();
    }


}
