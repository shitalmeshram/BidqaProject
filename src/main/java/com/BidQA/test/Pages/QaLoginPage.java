package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/15/2017.
 */
public class QaLoginPage {
    WebDriver driver;

       public QaLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Login link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/wp-login.php']")
    private WebElement loginBtn;

    //Define Login method
    public void ClickLoginBtn(){
        loginBtn.click();
    }


   //Define Username
    @FindBy(how= How.XPATH, using="//input[@id='log']")
    private WebElement enterUname;

    //Define Password
    @FindBy(how= How.XPATH, using="//input[@id='login_password']")
    private WebElement enterPwd;

    //Define Sign in btn
    @FindBy(how= How.XPATH, using="//input[@class='submit_bottom']")
    private WebElement signInBtn;

    //Define username method
    public void EnterUserName(){
        enterUname.sendKeys("minnie");
    }
    //Define password method
    public void EnterPwd(){
        enterPwd.sendKeys("1234");
    }
    //Define Sign in method
    public void ClickSignBtn(){
        signInBtn.click();
    }

}
