package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/15/2017.
 */
public class LogoutPage {
    WebDriver driver;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Logout Link
    @FindBy(how= How.XPATH, using="//a[contains(@href,'http://test.bidqa.com/wp-login.php?action=logout&_wpnonce')]")
    private WebElement logoutLink;

    //Define Logout Button Click Method
    public void ClickLogoutLink()
    {
        logoutLink.click();
    }
}
