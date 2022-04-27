package utils;

import com.google.common.io.Files;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by vuongphan on 04/27/2022 - - 11:09
 *
 * @project nopCommerce-Selenium-Cucumber
 */
public class TakeScreenshotUtil {
    private static File mavenProjectBuildDirectory = new File(System.getProperty("maven.project.build.directory",
            "./target/"));
    private static File screenshotsOutputDir = new File(mavenProjectBuildDirectory, "screenshots");
    private static File failuresOutputDir = new File(mavenProjectBuildDirectory, "failures");

    private static void takeScreenshot(WebDriver driver, File imageOutputFile) {
        try {
            File directory = imageOutputFile.getParentFile();
            FileUtils.forceMkdir(directory);

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, imageOutputFile);

            //Attach to Allure Report
            byte[] bytes = Files.toByteArray(imageOutputFile);
            Allure.addByteAttachmentAsync(imageOutputFile.getName(), "image/png", () -> bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void takeScreenshot(WebDriver driver, String fileName, Class<?> testClass) {
        String timeStamp = System.currentTimeMillis() / 1000 + "";
        File imageOutputFile = new File(screenshotsOutputDir,
                "/" + fileName.replaceAll(" ", "_") + "-" + timeStamp + ".png");
        takeScreenshot(driver, imageOutputFile);
    }


    public static void takeScreenShotFailureScenario(WebDriver driver, String fileName) {
        String timeStamp = System.currentTimeMillis() / 1000 + "";
        File imageOutputFile = new File(failuresOutputDir, fileName.replaceAll(" ", "_") + "-" + timeStamp + ".png");
        takeScreenshot(driver, imageOutputFile);
    }
}
