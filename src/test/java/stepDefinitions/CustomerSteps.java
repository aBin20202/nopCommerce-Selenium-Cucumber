package stepDefinitions;

import cucumber.BaseSteps;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.CustomerPage;

/**
 * Created by vuongphan on 04/27/2022 - - 12:20
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class CustomerSteps extends BaseSteps {
    private CustomerPage customerPage = new CustomerPage(DriverFactory.getDriver());
    @And("click on Add new button")
    public void clickOnAddNewButton() {
        customerPage.clickOnAddNew();
    }

    @And("user is redirected to {string} page")
    public void userIsRedirectedToAddANewCustomerPage(String expectedTitle) {
        Assertions.assertThat(getPageTitle()).containsIgnoringCase(expectedTitle);

    }

    @And("fill customer information")
    public void fillCustomerInformation() {
        String email = randomString() + "@gmail.com";
        customerPage
                .setEmail(email)
                .setPassword("123")
                .setFirstName("Pavan")
                .setLastName("Kumar")
                .setGender("Female")
                .setDOB("7/15/1985")
                .setCompanyName("QA")
                .selectIsTaxExempt(true)
                .setManagerOfVendor("Vendor 2")
                .selectActive(false)
                .setAdminContent("This is for Testing...");
    }

    @And("click on Save button")
    public void clickOnSaveButton() {
        customerPage.clickOnSave();
    }

    @Then("verify that user should see confirmation message {string}")
    public void verifyThatUserShouldSeeConfirmationMessage(String msgConfirmation) {
        Assertions.assertThat(customerPage.getMessage())
                .contains(msgConfirmation);
    }


}
