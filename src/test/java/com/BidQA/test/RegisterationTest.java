package com.BidQA.test;

import com.BidQA.test.Resources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by shail on 5/10/2017.
 */
public class RegisterationTest {
    WebDriver driver;
    PageResources pageResources;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to("http://test.bidqa.com/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void HomePageTest(){
        pageResources = new PageResources(driver);
        // Click Register link
        pageResources.getHomePage().ClickRegisterLink();
    }

    @Test(priority = 2)
    public void RegistrationPageTest(){
        pageResources = new PageResources(driver);
        //Enter username
        pageResources.getRegisterationPage().EnterUserName();
        //Enter Email
        pageResources.getRegisterationPage().EnterEmail();
        //Enter pwd
        pageResources.getRegisterationPage().EnterPwd();
        //Enter Repeat pwd
        pageResources.getRegisterationPage().EnterRepeatPwd();
        //Click PO radio button
        pageResources.getRegisterationPage().CheckProjectOwner();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        /*//Click recaptcha checkbox
        driver.switchTo().defaultContent();
        driver.switchTo().frame("recaptcha widget");
        pageResources.getRegisterationPage().CheckRecaptchaBox(); */
        //Click Register Button
        pageResources.getRegisterationPage().CheckRegisterBtn();


    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
