package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/10/2017.
 */
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Login Link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/wp-login.php']")
    private WebElement loginLink;

    //Define Register Button Click Method
    public void ClickLoginLink()
    {
        loginLink.click();
    }

    //Define Register Link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/wp-login.php?action=register']")
    private WebElement registerLink;

    //Define Register Button Click Method
    public void ClickRegisterLink()
    {
        registerLink.click();
    }
}
