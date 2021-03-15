package org;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGuys {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vidhan Chandra\\Downloads\\Excel\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();
        driver.findElement(By.id("session_key")).sendKeys("-----");
        driver.findElement(By.id("session_password")).sendKeys("----------");
        driver.findElement(By.className("sign-in-form__submit-button")).click();

        /*
        * To withdraw request
        * */
        /*
        driver.findElement(By.xpath("//li[@class='global-nav__primary-item']/a[@href='/mynetwork/']")).click();
        driver.findElement(By.className("msg-overlay-bubble-header")).click();
        driver.findElement(By.xpath("//span[text()= 'Manage']/parent::a[1]")).click();
        driver.findElement(By.xpath("//button[text()= 'Sent']")).click();
        Thread.sleep(5000);
        List<WebElement> lstbtn = driver.findElements(By.xpath("//span[text()= 'Withdraw']/parent::button"));
        System.out.print(lstbtn.size());
        for (int i = 0 ; i < lstbtn.size(); i++){
            Thread.sleep(1000);
            lstbtn.get(i).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[text()='Withdraw']/parent::button[contains(@class, 'artdeco-modal__confirm-dialog-btn')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(@class, 'artdeco-toast-item__dismiss')]")).click();
        }
        */

        /*To send connection request
        *
        * */
        driver.findElement(By.xpath("//li[@class='global-nav__primary-item']/a[@href='/mynetwork/']")).click();
        driver.findElement(By.className("msg-overlay-bubble-header")).click();
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        search.sendKeys("sdet 3");
        search.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='See all people results']")).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(6000);
        driver.findElement(By.xpath("//span[text()='8']/parent::button")).click();
        Thread.sleep(5000);
        List<WebElement> lst = driver.findElements(By.xpath("//span[text()='Connect']/parent::button"));
        System.out.println(lst.size());
        for (int i = 0 ; i < lst.size(); i++){
            //Thread.sleep(8000);
            lst.get(i).click();
          //Thread.sleep(2000);
            driver.findElement(By.xpath("//span[text()='Send']/parent::button")).click();
        }

    }
}
