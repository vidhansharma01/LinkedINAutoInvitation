package org.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageObjects.HomePage;
import org.pageObjects.LoginOrSignUpPage;
import org.pageObjects.MyNetworkPage;

import java.util.List;

public class stepDefination extends base {
    /*
    Withdraw connection
    */
    public WebDriver driver;
    @Given("^User is on Welcome page$")
    public void user_is_on_welcome_page() throws Throwable {
        driver = initializeDriver();
    }

    @When("^User enter email as \"([^\"]*)\" & password \"([^\"]*)\"$")
    public void user_enter_email_as_something_password_something(String email, String password) throws Throwable {
        LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
        loginOrSignUpPage.getEmailElement().sendKeys(email);
        loginOrSignUpPage.getPasswordElement().sendKeys(password);
        loginOrSignUpPage.getSubmitBtnElement().click();

    }
    @And("^User click on My Network$")
    public void user_click_on_my_network() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.getMsgBubble().click();
        homePage.getMyNetwork().click();
        Thread.sleep(2000);
    }
    MyNetworkPage myNetworkPage;
    @And("^User click on Manage Text$")
    public void user_click_on_manage_text() throws Throwable {
        myNetworkPage = new MyNetworkPage(driver);
        myNetworkPage.getManage().click();
    }

    @And("^User click on the Sent button$")
    public void user_click_on_the_sent_button() throws Throwable {
        myNetworkPage.getRequestSent().click();
    }

    @And("^User click on the Withdraw button to withdraw the connection request$")
    public void user_click_on_the_withdraw_button_to_withdraw_the_connection_request() throws Throwable {
        Thread.sleep(5000);
        List<WebElement> lstButtons = myNetworkPage.getButtons();
        for (int i = 0; i < lstButtons.size(); i++){
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.elementToBeClickable(lstButtons.get(i)));
            lstButtons.get(i).click();
            myNetworkPage.getWithdrawModal().click();
            myNetworkPage.deleteToastMsg().click();
        }
    }
    @Then("^The connection are withdrawn$")
    public void the_connection_are_withdrawn() throws Throwable {

    }

    /*
        Send connection requests
     */
    @And("^User enters \"([^\"]*)\" in the search bar$")
    public void user_enters_something_in_the_search_bar(String roles) throws Throwable {
        myNetworkPage = new MyNetworkPage(driver);
        myNetworkPage.getSearchBar().sendKeys(roles);
        myNetworkPage.getSearchBar().sendKeys(Keys.RETURN);
    }
    @And("^User click on See all People link$")
    public void user_click_on_see_all_people_link() throws Throwable {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(myNetworkPage.getAllPeople()));
        myNetworkPage.getAllPeople().click();
        Thread.sleep(5000);
        //Scroll to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1500)");
        Thread.sleep(5000);
        //Click on PageNavigator
        myNetworkPage.getPageNavigator();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0, -1500)");
    }
    private JavascriptExecutor js;
    @And("^User click on Connect button$")
    public void user_click_on_connect_button() throws Throwable {
        js = (JavascriptExecutor) driver;
        List<WebElement> lstConnectBtn = myNetworkPage.getConnectBtn();
        for (int i = 0; i < lstConnectBtn.size(); i++) {
            lstConnectBtn.get(i).click();
            WebElement sendBtn = myNetworkPage.getSendBtn();
            if (sendBtn.isEnabled())
                driver.findElement(By.xpath("//span[text()='Send']/parent::button")).click();
            else{
                driver.findElement(By.xpath("//button[contains(@class, 'artdeco-modal__dismiss artdeco-button artdeco-button--circle ')]")).click();
            }
            js.executeScript("window.scrollBy(0, 100)");
        }
    }
    @Then("^Connect requet is send$")
    public void connect_requet_is_send() throws Throwable {

    }
}
