package com.BidQA.test.Resources;

import com.BidQA.test.Pages.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by shail on 5/10/2017.
 */
public class PageResources {
    WebDriver driver;
    HomePage homePage;
    RegisterationPage registerationPage;
    MyAccountPage myAccountPage;
    PostNewProjectPage postNewProjectPage;
    PayPalPage payPalPage;
    LogoutPage logoutPage;
    QaLoginPage qaLoginPage;

       public PageResources(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        registerationPage = new RegisterationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        postNewProjectPage = new PostNewProjectPage(driver);
        payPalPage = new PayPalPage(driver);
        logoutPage = new LogoutPage(driver);
        qaLoginPage = new QaLoginPage(driver);

    }
    public HomePage getHomePage() {
        return homePage;
    }
    public RegisterationPage getRegisterationPage() {
        return registerationPage;
    }

    public MyAccountPage getMyAccountPage() {
        return myAccountPage;
    }
    public PostNewProjectPage getPostNewProjectPage() {
        return postNewProjectPage;
    }
    public PayPalPage getPayPalPage() {
        return payPalPage;
    }
    public LogoutPage getLogoutPage() {
        return logoutPage;
    }
    public QaLoginPage getQaLoginPage() {
        return qaLoginPage;
    }
}