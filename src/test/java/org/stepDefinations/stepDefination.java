package org.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pageObjects.HomePage;
import org.pageObjects.LoginOrSignUpPage;
import org.pageObjects.MyNetworkPage;

import java.util.List;

public class stepDefination extends base {
    /*
    Login Test case
    */
    WebDriver driver;
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

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //User is able to login
    }
    /*
    Clicking on MyNetwork TestCase
    */
    @Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable {
        //User is on home page already
    }

    @When("^User click on My Network$")
    public void user_click_on_my_network() throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.getMyNetwork().click();
    }

    @Then("^User is navigated to their network page$")
    public void user_is_navigated_to_their_network_page() throws Throwable {
        //User is navigated to that page
    }
    /*User click on Manage Text
    * */
    @Given("^User is on MyNetwork Page$")
    public void user_is_on_mynetwork_page() throws Throwable {
        //User is on the network page
    }
    MyNetworkPage myNetworkPage;
    @When("^User click on Manage Text$")
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
        List<WebElement> lstButtons = myNetworkPage.getButtons();
        for (int i = 0; i < lstButtons.size(); i++){
            lstButtons.get(i).click();
            Thread.sleep(300);
        }
    }
    @Then("^User is naviagted to the Manage Invitations Page$")
    public void user_is_naviagted_to_the_manage_invitations_page() throws Throwable {

    }


}
