package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyNetworkPage extends PageBase{
    public MyNetworkPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()= 'Manage']")
    private WebElement manage;

    @FindBy(xpath = "//button[text()= 'Sent']")
    private WebElement RequestSent;

    @FindBy(xpath = "//span[text()= 'Withdraw']/parent::button")
    private List<WebElement> buttons;

    public WebElement getManage(){
        return manage;
    }

    public WebElement getRequestSent(){
        return RequestSent;
    }
    public List<WebElement> getButtons(){
        return buttons;
    }
}
