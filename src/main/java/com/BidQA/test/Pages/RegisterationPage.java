package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/10/2017.
 */
public class RegisterationPage {
    WebDriver driver;
    DataGenerator dataGenerator = new DataGenerator();

    public RegisterationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Username
    @FindBy(how= How.XPATH, using="//input[@id='log']")
    private WebElement enterUname;

    //Define Email
    @FindBy(how= How.XPATH, using="//input[@id='user_email']")
    private WebElement enterEmail;

    //Define Password
    @FindBy(how= How.XPATH, using="//input[@id='login_password']")
    private WebElement enterPwd;

    //Define Repeat Pwd
    @FindBy(how= How.XPATH, using="//input[@id='pass2']")
    private WebElement enterRepeatPwd;

    //Define PO radio button
    @FindBy(how= How.XPATH, using="//input[@value='business_owner']")
    private WebElement chkProjectOwner;

    //Define recaptcha box
    @FindBy(how= How.XPATH, using="//div[@class='recaptcha-checkbox-checkmark']")
    private WebElement chkReCaptcha;

    //Define Register button
    @FindBy(how= How.XPATH, using="//input[@value='Register']")
    private WebElement registerBtn;

    //Define Sign In button
    @FindBy(how= How.XPATH, using="//input[@value='Sign in']")
    private WebElement signInBtn;

    //Define Username Method
    public void EnterUserName()
    {
        enterUname.sendKeys(dataGenerator.usernameChars);
    }
    //Define Email Method
    public void EnterEmail()
    {
        enterEmail.sendKeys(dataGenerator.randomEmailChars);
    }
    //Define Password Method
    public void EnterPwd()
    {
        enterPwd.sendKeys(dataGenerator.popwd);
    }
    //Define Repeat Pwd Method
    public void EnterRepeatPwd()
    {
        enterRepeatPwd.sendKeys(dataGenerator.repwdChars);
    }
    // Define radio type method
    public void CheckProjectOwner(){
        chkProjectOwner.click();
    }
    //Define Recaptcha method
    public void CheckRecaptchaBox(){
        chkReCaptcha.click();
    }
    //Define Register method
    public void CheckRegisterBtn(){
        registerBtn.click();
    }
    //Define SignIn method
    public void ClickSignInBtn(){
        signInBtn.click();
    }
}
