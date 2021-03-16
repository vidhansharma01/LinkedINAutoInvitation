package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//li[@class='global-nav__primary-item']/a[@href='/mynetwork/']")
    private WebElement myNetwork;

    @FindBy(className = "msg-overlay-bubble-header")
    private WebElement msgBubble;

    public WebElement getMyNetwork(){
        return myNetwork;
    }

    public WebElement getMsgBubble(){
        return msgBubble;
    }
}
