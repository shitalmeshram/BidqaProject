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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
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
        // Click Login link
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

        //Verifying that logged in as a Project Owner
        try{
            java.lang.String poTitle =  pageResources.getMyAccountPage().GetPresentText();
            assertEquals("You are logged in as a Project Owner",poTitle);
            System.out.println("Text = "+ poTitle);
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
            java.lang.String infoText = pageResources.getMyAccountPage().GetProjectText();
            assertEquals("Project Main Information", infoText);
            System.out.println("Text Present = " + infoText);
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

        //Verify that logged in as a QA Engineer
        try {
            java.lang.String qaTitle = pageResources.getQaLoginPage().GetPresentText();
            assertEquals("You are logged in as a QA Engineer", qaTitle);
            System.out.println("Text = " + qaTitle);
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }


        //Caliing QaBiddingProject method from helper class
        BidQaHelperClass.QaBiddingProject(pageResources, driver, hashMap);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Verify Status
        try {
            java.lang.String statusText = pageResources.getQaBiddingProjectPage().GetStatusText();
            assertEquals("Congratulations!", statusText);
            System.out.println("Status = " + statusText);
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click Ok Btn
        pageResources.getQaBiddingProjectPage().ClickOkBtn();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // --------------- Select Winner Test----------------------

        //Calling PO Login Method from helper call
        BidQaHelperClass.PoLogin(pageResources, driver);

        //Verifying that logged in as a Project Owner
        try {
            java.lang.String poTitle = pageResources.getMyAccountPage().GetPresentText();
            assertEquals("You are logged in as a Project Owner", poTitle);
            System.out.println("Text = " + poTitle);
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }
        //Click project name
        pageResources.getSelectWinnerPage().ClickProjectName();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //click on select as winner
        pageResources.getSelectWinnerPage().ClickSelectWinner();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //click on Choose a winner Btn
        pageResources.getSelectWinnerPage().ChooseWinnerBtn();

        //Verifying Status
        java.lang.String statusName = pageResources.getSelectWinnerPage().GetStatus();
        Assert.assertTrue(true,statusName);
        System.out.println("Project Name ="+statusName);



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click on logout link
        pageResources.getLogoutPage().ClickLogoutLink();


        //------------------------- Project Progress Test------------------------------
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Calling QA Login Method from helper call
        BidQaHelperClass.QaLogin(pageResources, driver);

        //Verify that logged in as a QA Engineer
        try {
            java.lang.String qaTitle = pageResources.getQaLoginPage().GetPresentText();
            assertEquals("You are logged in as a QA Engineer", qaTitle);
            System.out.println("Text = " + qaTitle);
        } catch (Exception e) {
            System.err.println("assertequals fail");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       /* //Verifying Project name
        java.lang.String projectName = pageResources.getProjectProgressPage().GetProjectName();
        Assert.assertTrue(true,projectName);
        System.out.println("Project Name ="+projectName);
*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click on project in progress link
        pageResources.getProjectProgressPage().ClickProjectInProgressLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        java.lang.String title = (java.lang.String) hashMap.get("Title");
        //Define project name field
        List<WebElement> myList = driver.findElements(By.xpath("//div[@class='padd10']//a[contains(@href,'http://test.bidqa.com/projects/bbox')]"));

        int counter = 0;
        for (WebElement myElement : myList) {

            counter++;

            java.lang.String myProject = myElement.getText();
            System.out.println(myProject);

            //2. If Project title matches the desired project then proceed
            if (myProject.contains(title)) {

                System.out.println(counter);

                //a. Click on 'Start Work Timer' button
                driver.findElements(By.xpath("//div[@class='padd10']//button[@class='work_timer green_btn']")).get(counter - 1).click();
                Thread.sleep(3000);
                //b. Then click on 'Accept' checkbox
                driver.findElements(By.xpath("//input[@type='checkbox']")).get(counter - 1).click();
                Thread.sleep(3000);
                //c. Then click on 'Ok' button
                driver.findElements(By.xpath("//input[@value='ok']")).get(counter - 1).click();
                //d. Wait for 10 seconds to finish work
                Thread.sleep(10000);
                //e. After 10 seconds stop timer
                driver.findElements(By.xpath("//button[@act='stop']")).get(counter - 1).click();
                Thread.sleep(3000);
                //f. Then click on 'Mark Delivered' button
                driver.findElements(By.xpath("//a[@class='green_btn']")).get(counter - 1).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //g. Then click on 'Yes, Mark Delivered!' button
                pageResources.getProjectProgressPage().ClickYesBtn();

                break;

            } else {
                System.out.println("Project not found");
            }

        }

        }





    @AfterClass
    public void afterClass() throws InterruptedException {
        //Close the browser
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.close();
        //driver.quit();
    }
}
