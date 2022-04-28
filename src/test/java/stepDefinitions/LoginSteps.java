package stepDefinitions;

import cucumber.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

/**
 * Created by vuongphan on 04/27/2022 - - 11:00
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class LoginSteps extends BaseSteps {
    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        navigateToLogin();
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
