package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by vuongphan on 04/27/2022 - - 11:01
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    @CacheLookup
    private WebElement btnLogin;

    public LoginPage setEmail(String email) {
        if (txtEmail.getAttribute("value") != null) {
            txtEmail.clear();
        }
        txtEmail.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        if (txtPassword.getAttribute("value") != null) {
            txtPassword.clear();
        }
        txtPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickOnLogin() {
        btnLogin.submit();
        return this;
    }

    public DashboardPage doLogin(String email, String password) {
        System.out.println("Login with " + email + " and " + password);
        setEmail(email);
        setPassword(password);
        clickOnLogin();
        return new DashboardPage(driver);
    }
}
