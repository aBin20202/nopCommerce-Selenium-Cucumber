package stepDefinitions;

import cucumber.BaseSteps;
import io.cucumber.datatable.DataTable;
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


    @Given("user has already logged in to the application")
    public void userHasAlreadyLoggedInToTheApplication() {
        navigateToLogin();
        loginPage
                .setEmail(prop.getProperty("username") == null ? "admin@gmail.com" : prop.getProperty("username"))
                .setPassword(prop.getProperty("password") == null ? "Admin" : prop.getProperty("password"))
                .clickOnLogin();

    }

}
