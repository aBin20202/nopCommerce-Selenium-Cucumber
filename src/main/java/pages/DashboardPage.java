package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vuongphan on 04/27/2022 - - 11:02
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    @CacheLookup
    private WebElement lblHeader;

    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement lnkLogout;

    @FindBy(xpath = "//a[@href='#']/p[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement lnkCustomers_menu;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement lnkCustomers_menuitem;

    public String getTitleHeader(){
        return lblHeader.getText();
    }

    public void clickOnLogout() {
        lnkLogout.click();
    }




    public void clickOnCustomersMenu() {
        lnkCustomers_menu.click();
    }

    public void clickOnCustomersMenuItem() {
        lnkCustomers_menuitem.click();
    }
}
