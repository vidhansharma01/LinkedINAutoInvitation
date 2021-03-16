package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrSignUpPage extends PageBase {
    public LoginOrSignUpPage(WebDriver driver){
        super(driver);
        driver.manage().window().maximize();
    }

    @FindBy(id="session_key")
    private WebElement email;

    @FindBy(id="session_password")
    private WebElement password;

    @FindBy(className = "sign-in-form__submit-button")
    private WebElement submitBtn;

    public WebElement getEmailElement(){
        return email;
    }
    public WebElement getPasswordElement(){
        return password;
    }
    public WebElement getSubmitBtnElement(){
        return submitBtn;
    }
}
