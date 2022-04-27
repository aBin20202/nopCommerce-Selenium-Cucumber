package stepDefinitions;

import cucumber.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

/**
 * Created by vuongphan on 04/27/2022 - - 12:20
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class CustomerSteps extends BaseSteps {
    @And("click on Add new button")
    public void clickOnAddNewButton() {
        customerPage.clickOnAddNew();
    }

    @Then("user can view Add a new customer page")
    public void userCanViewAddANewCustomerPage() {
        Assertions.assertThat(driver.getTitle())
                .isEqualToIgnoringCase("Add a new customer / nopCommerce administration");
    }

    @When("user enters customer info")
    public void userEntersCustomerInfo() {
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

    @Then("user can view confirmation message {string}")
    public void userCanViewConfirmationMessage(String msgConfirmation) {
        Assertions.assertThat(customerPage.getMessage())
                .contains(msgConfirmation);
    }
}
