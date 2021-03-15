package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public Properties properties;
    public WebDriver initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Vidhan Chandra\\Downloads\\Excel\\src\\test\\resources\\data.properties");
        properties.load(fis);
        String browser = properties.getProperty("browser");
        if (browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vidhan Chandra\\Downloads\\Excel\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
