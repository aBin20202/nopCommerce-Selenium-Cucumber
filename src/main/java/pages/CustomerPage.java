package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by vuongphan on 04/27/2022 - - 11:05
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class CustomerPage {
    WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='btn btn-primary']")
    @CacheLookup
    private WebElement btnAddNew;

    @FindBy(partialLinkText = "Add a new customer")
    @CacheLookup
    private WebElement lblPage;

    @FindBy(partialLinkText = "back to")
    @CacheLookup
    private WebElement lnkBackToList;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement btnSave;

    @FindBy(name = "save-continue")
    @CacheLookup
    private WebElement btnSaveToEdit;

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(id = "FirstName")
    @CacheLookup
    private WebElement txtFirstName;

    @FindBy(id = "LastName")
    @CacheLookup
    private WebElement txtLastName;

    @FindBy(name = "Gender")
    @CacheLookup
    private List<WebElement> radGender;

    @FindBy(id = "DateOfBirth")
    @CacheLookup
    private WebElement txtDOB;

    @FindBy(id = "Company")
    @CacheLookup
    private WebElement txtCompanyName;

    @FindBy(id = "IsTaxExempt")
    @CacheLookup
    private WebElement chkIsTaxExempt;

    @FindBy(id = "SelectedNewsletterSubscriptionStoreIds_listbox")
    @CacheLookup
    private WebElement lstNewsletter;

    @FindBy(id = "SelectedCustomerRoleIds_taglist")
    @CacheLookup
    private List<WebElement> lstCustomerRoles;

    @FindBy(id = "VendorId")
    @CacheLookup
    private WebElement drpdwnManagerOfVendor;

    @FindBy(id = "Active")
    @CacheLookup
    private WebElement chkActive;

    @FindBy(id = "AdminComment")
    @CacheLookup
    private WebElement txtAdminContent;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    @CacheLookup
    private WebElement msgConfirmation;


    //TODO: Action
    public CustomerPage getPageTitle() {
        driver.getTitle();
        return this;

    }

    public void clickOnAddNew() {
        btnAddNew.click();
    }

    public CustomerPage setEmail(String email) {
        txtEmail.sendKeys(email);
        return this;
    }

    public CustomerPage setPassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }

    public CustomerPage setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
        return this;
    }

    public CustomerPage setLastName(String lname) {
        txtLastName.sendKeys(lname);
        return this;
    }

    public CustomerPage setGender(String gender) {
        final int Male = 0;
        final int Female = 1;
        if (gender.equals("Male")) {
            radGender.get(Male).click();
        } else if (gender.equals("Female")) {
            radGender.get(Female).click();
        } else {
            radGender.get(Male).click(); //Default
        }
        return this;
    }


    public CustomerPage setDOB(String dob) {
        txtDOB.sendKeys(dob);
        return this;
    }


    public CustomerPage setCompanyName(String comname) {
        txtCompanyName.sendKeys(comname);
        return this;
    }

    public CustomerPage selectIsTaxExempt(boolean flag) {
        if (!flag & chkIsTaxExempt.isSelected()) {
            chkIsTaxExempt.click();
        } else if (flag & !chkIsTaxExempt.isSelected()) {
            chkIsTaxExempt.click();
        }
        return this;
    }


    public CustomerPage selectNewsletter(String value) {
        return this;
    }

    public CustomerPage setCustomerRoles(String role) {
        return this;
    }

    public CustomerPage setManagerOfVendor(String value) {
        Select drp = new Select(drpdwnManagerOfVendor);
        drp.selectByVisibleText(value);
        return this;
    }


    public CustomerPage selectActive(boolean flag) {
        if (!flag && chkActive.isSelected()) {
            chkActive.click();
        } else if (flag & !chkActive.isSelected()) {
            chkActive.click();
        }
        return this;
    }


    public CustomerPage setAdminContent(String content) {
        txtAdminContent.sendKeys(content);
        return this;
    }

    public void clickOnSave() {
        btnSave.click();
    }

    public String getMessage() {
        return msgConfirmation.getText();
    }
}
