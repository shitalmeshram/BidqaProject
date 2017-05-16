package com.BidQA.test;

import com.BidQA.test.Data.DataGenerator;
import com.BidQA.test.Data.DataProviderClass;
import com.BidQA.test.Pages.BidQaHelperClass;
import com.BidQA.test.Resources.PageResources;
import junit.framework.ComparisonFailure;
import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import java.lang.*;

/**
 * Created by shail on 5/10/2017.
 */
public class LoginTest {
    WebDriver driver;
    String title;
    PageResources pageResources;
    DataGenerator dataGenerator = new DataGenerator();
    //String title =dataGenerator.randomTitleChars;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://test.bidqa.com/");
        driver.manage().window().maximize();

    }

   @Test(priority = 1)
    public void HomePageTest() {
        pageResources = new PageResources(driver);
        // Click Register link
        pageResources.getHomePage().ClickLoginLink();
    }
    @Test(priority = 2)
    public void RegistrationPageTest() {
        pageResources = new PageResources(driver);
        //Enter username
        pageResources.getRegisterationPage().EnterUserName();
        //Enter pwd
        pageResources.getRegisterationPage().EnterPwd();
        //Click Sign In button
        pageResources.getRegisterationPage().ClickSignInBtn();
    }
    @Test(priority = 3)
    public void MyaccountPageTest(){
        pageResources = new PageResources(driver);

        //Verifying text
        try{
            assertEquals("You are logged in as a Project Owner", pageResources.getMyAccountPage().GetPresentText());
            System.out.println("Text = "+ pageResources.getMyAccountPage().GetPresentText());
        }catch(Exception e){
            System.err.println("assertequals fail");
        }

        //Click on post new project link
        pageResources.getMyAccountPage().ClickPostNewProLink();
    }

    @Test(priority = 4)
    public void BidQaProjectTest() throws InterruptedException {
        pageResources = new PageResources(driver);

        //Verifying project information text
        try {
            assertEquals("Project Main Information", pageResources.getMyAccountPage().GetProjectText());
            System.out.println("Text Present = " + pageResources.getMyAccountPage().GetProjectText());
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }

        //Calling PostNewProject from helper class
        HashMap hashMap = BidQaHelperClass.PostNewProject(pageResources, driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Calling Paypal method from helper calss
        BidQaHelperClass.PayPal(pageResources, driver);

        //Logout
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();

        //Calling QA Login Method from helper call
        BidQaHelperClass.QaLogin(pageResources, driver);

        //Caliing QaBiddingProject method from helper class
        BidQaHelperClass.QaBiddingProject(pageResources, driver, hashMap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Verify Status
        try {
            java.lang.String statusText = pageResources.getQaBiddingProjectPage().GetStatusText();
            assertEquals("Congratulations!", statusText);
            System.out.println("Text Present = " + statusText);
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click Ok Btn
        pageResources.getQaBiddingProjectPage().ClickOkBtn();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();


    }




    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
