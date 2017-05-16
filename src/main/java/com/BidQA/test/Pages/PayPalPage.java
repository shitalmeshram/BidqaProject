package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/11/2017.
 */
public class PayPalPage {
    WebDriver driver;
    DataGenerator dataGenerator = new DataGenerator();


    public PayPalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Define email field
    @FindBy(how= How.XPATH, using="html/body/div[1]/section/div/div/form/div[1]/div[1]/div[1]/input")
    private WebElement enterEmail;

    //Define email Method
    public void EnterEmail()
    {
        enterEmail.clear();
        enterEmail.sendKeys("sh.meshram@gmail.com");
    }

    //Define password field
    @FindBy(how= How.XPATH, using="html/body/div[1]/section/div/div/form/div[1]/div[2]/div[1]/input")
    private WebElement enterPwd;

    //Define password Method
    public void EnterPwd()
    {
        enterPwd.clear();
        enterPwd.sendKeys("oct05dec05");
    }
    //Define log in field
    @FindBy(how= How.XPATH, using="//button[@id='btnLogin']")
    private WebElement logInBtn;

    //Define log in Method
    public void ClickLogInBtn()
    {
        logInBtn.click();
    }
    //Define pay now in field (//input[@value='Pay Now'])
    @FindBy(how= How.XPATH, using="//input[@id='confirmButtonTop']")
    private WebElement payNowBtn;

    //Define pay now Method
    public void ClickPayNowBtn()
    {
        payNowBtn.click();
    }

    //Define return to merchant field
    @FindBy(how= How.XPATH, using="//input[@id='merchantReturnBtn']")
    private WebElement returnToMerchant;

    //Define pay now Method
    public void ClickReTomerchant()
    {
        returnToMerchant.click();
    }
}
