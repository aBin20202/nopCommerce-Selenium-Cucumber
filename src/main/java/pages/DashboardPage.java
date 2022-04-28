package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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


    @FindBy(xpath = "//*[@class='mt-2']/ul")
    @CacheLookup
    private WebElement menuParent;

    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']/ul")
    @CacheLookup
    private WebElement menuChild;


    @FindBy(xpath = "//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]")
    @CacheLookup
    private WebElement lnkCustomers_menuitem;

    public String getTitleHeader() {
        return lblHeader.getText();
    }

    public void clickOnLogout() {
        lnkLogout.click();
    }

    public void selectMenuMain(String menuName) {
        List<WebElement> menus = menuParent.findElements(By.tagName("li"));
        for (WebElement menu : menus) {
            if (menu.getText().equalsIgnoreCase(menuName)) {
                menu.click();
                break;
            }
        }
    }

    public void selectMenuChild(String menuName) {
        List<WebElement> menus = menuChild.findElements(By.tagName("li"));
        for (WebElement menu : menus) {
            System.out.println(menu.getText());
            if (menu.getText().equalsIgnoreCase(menuName)) {
                menu.click();
                break;
            }
        }
    }

//        public void selectChildMenuInParentMenu(String parentName, String childName){
//        List<WebElement> parenMenu = menuParent.findElements(By.tagName("li"));
//        for(WebElement parent : parenMenu){
//            if(parent.getText().contains(parentName)){
//                parent.click();
//                List<WebElement> childMenu = menuChild.findElements(By.tagName("li"));
//                for (WebElement child : childMenu){
//                    if (child.getText().contains(childName)){
//                        child.click();
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//    }

    public CustomerPage selectMenu(String parentName, String childName) {
        List<WebElement> parenMenu = menuParent.findElements(By.tagName("li"));
        for (WebElement parent : parenMenu) {
            if (parent.getText().contains(parentName)) {
                parent.click();
                List<WebElement> childMenu = menuChild.findElements(By.tagName("li"));
                for (WebElement child : childMenu) {
                    if (child.getText().contains(childName)) {
                        child.click();
                        break;
                    }
                }
                break;
            }
        }
        return new CustomerPage(driver);
    }
}
