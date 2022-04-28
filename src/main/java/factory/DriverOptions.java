package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyUtil;

/**
 * Created by vuongphan on 04/28/2022 - - 18:39
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class DriverOptions {

    private static final PropertyUtil prop = new PropertyUtil();

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(Boolean.getBoolean("isHeadless"))
                .addArguments("--disable-dev-shm-usage") // overcome limited resource problems
                .addArguments("--no-sandbox")
//                        .addArguments("--remote-debugging-port=9222")
                .addArguments("disable-features=NetworkService")
                .addArguments("enable-features=NetworkServiceInProcess")
                .addArguments("disable-infobars") // disabling information bars
                .addArguments("--disable-extensions") // disabling extensions
                .addArguments("--disable-gpu") // applicable to windows os only
                .addArguments("--log-level=3") // set log level
                .addArguments("--silent");
        return options;
    }

}
