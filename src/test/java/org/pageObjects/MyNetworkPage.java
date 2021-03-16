package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyNetworkPage extends PageBase{
    public MyNetworkPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()= 'Manage']/parent::a[1]")
    private WebElement manage;

    @FindBy(xpath = "//button[text()= 'Sent']")
    private WebElement RequestSent;

    @FindBy(xpath = "//span[text()= 'Withdraw']/parent::button")
    private List<WebElement> buttons;

    @FindBy(xpath = "//span[text()='Withdraw']/parent::button[contains(@class, 'artdeco-modal__confirm-dialog-btn')]")
    private WebElement withdrawModal;

    @FindBy(xpath = "//button[contains(@class, 'artdeco-toast-item__dismiss')]")
    private WebElement toastMsg;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchBar;

    @FindBy(xpath = "//a[text()='See all people results']")
    private WebElement allPeople;

    @FindBy(xpath = "//span[text()='Connect']/parent::button")
    private List<WebElement> lstConnectBtn;

    public WebElement getManage(){
        return manage;
    }

    public WebElement getRequestSent(){
        return RequestSent;
    }
    public List<WebElement> getButtons(){
        return buttons;
    }
    public WebElement getWithdrawModal(){
        return withdrawModal;
    }
    public WebElement deleteToastMsg(){
        return toastMsg;
    }
    public WebElement getSearchBar(){
        return searchBar;
    }
    public WebElement getAllPeople(){
        return allPeople;
    }
    private int page = 1;
    private String str = "//span[text()='" + page + "']/parent::button";

    By pageNavigator  = By.xpath(str);

    public void getPageNavigator(){
        driver.findElement(pageNavigator).click();
    }
    public List<WebElement> getConnectBtn(){
        return lstConnectBtn;
    }

    @FindBy(xpath = "//span[text()='Send']/parent::button")
    private WebElement sendBtn;

    public WebElement getSendBtn(){
        return sendBtn;
    }
}
