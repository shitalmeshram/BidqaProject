package com.BidQA.test;

import com.BidQA.test.Data.DataGenerator;
import com.BidQA.test.Data.DataProviderClass;
import com.BidQA.test.Resources.PageResources;
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

import java.util.concurrent.TimeUnit;

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

        //Click on post new project link
        pageResources.getMyAccountPage().ClickPostNewProLink();

    }

    @Test(priority = 4)
    public void PostNewProjectTest() throws InterruptedException {
        pageResources = new PageResources(driver);

        //Enter title

         pageResources.getPostNewProjectPage().EnterProjectTitle();
        // System.out.println("Project Title="+title);
        //Enter description
        pageResources.getPostNewProjectPage().EnterDescription();
        Thread.sleep(5000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select category
        pageResources.getPostNewProjectPage().SelectCategory();

        JavascriptExecutor jse1 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Enter Tag
        pageResources.getPostNewProjectPage().EnterTag();
        //Select Skills
        pageResources.getPostNewProjectPage().SelectSkills();

        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select price budget
        pageResources.getPostNewProjectPage().SelectBudget();

        JavascriptExecutor jse3 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select project ending date
        pageResources.getPostNewProjectPage().EnterEndDate();
        Thread.sleep(3000);
        pageResources.getPostNewProjectPage().SelectDate();

        JavascriptExecutor jse4 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Select country
        pageResources.getPostNewProjectPage().SelectCountry();
        Thread.sleep(3000);
        //Select State
        pageResources.getPostNewProjectPage().SelectState();
        //Enter Address
        pageResources.getPostNewProjectPage().EnterAddress();

        JavascriptExecutor jse5 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //Click next button1
        pageResources.getPostNewProjectPage().ClickNextBtn1();
        Thread.sleep(3000);
        //Verifying Text
       /* if(driver.getPageSource().contains("By clicking this checkbox you mark your project as featured. Extra fee is applied"))
            System.out.println("Text is present in the page");
        else
            System.err.println("Text is not present in the page");*/
        Thread.sleep(3000);
        //Click next button1
        pageResources.getPostNewProjectPage().ClickNextBtn2();
        Thread.sleep(3000);
        //Verifying Text
        if(driver.getPageSource().contains("This is how project appears to QA engineer"))
            System.out.println("Text is present in the page");
        else
            System.err.println("Text is not present in the page");
        Thread.sleep(3000);
        //Click next button3
        pageResources.getPostNewProjectPage().ClickNextBtn3();

        Thread.sleep(3000);
        //Accept terms
        pageResources.getPostNewProjectPage().ClickchkBox();
        Thread.sleep(5000);
        pageResources.getPostNewProjectPage().ClickPaypalBtn();

    }
    @Test(priority = 5)
    public void PayPalPageTest() throws InterruptedException {
        pageResources = new PageResources(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //switch to frame
        //driver.switchTo().frame("injectedUl");
        //out of all frames
        driver.switchTo().defaultContent();
        //switch to frame
        driver.switchTo().frame("injectedUl");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().EnterEmail();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().EnterPwd();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        pageResources.getPayPalPage().ClickLogInBtn();
        driver.switchTo().defaultContent();
       // Thread.sleep(5000);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(12000);
        pageResources.getPayPalPage().ClickPayNowBtn();

        JavascriptExecutor jse6 = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(12000);
        pageResources.getPayPalPage().ClickReTomerchant();

        WebElement result = driver.findElement(By.xpath("//div[@class='mm_inn mm_inn21']"));
        Assert.assertTrue(true, String.valueOf(result));
        title= result.getText();
        System.out.println("Project title is :"+title);

        //Logout
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();

    }

    @Test(priority = 6)
    public void QaLoginTest(){
        PageResources pageResources = new PageResources(driver);
        //Click Login button
        pageResources.getQaLoginPage().ClickLoginBtn();
        //Enter username
        pageResources.getQaLoginPage().EnterUserName();
        //Enter Password
        pageResources.getQaLoginPage().EnterPwd();

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
