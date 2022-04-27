package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by vuongphan on 04/27/2022 - - 11:07
 *
 * @project nopCommerce-Selenium-Cucumber
 */

public class PropertyUtil {
    private Properties prop;
    private String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/config.properties";

    public PropertyUtil() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            prop = new Properties();
            try {
                prop.load(bufferedReader);
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found at " + propertyFilePath);
        }
    }

    public PropertyUtil setFile(String propertyFilePath) {
        this.propertyFilePath = propertyFilePath;
        return this;
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }


}
