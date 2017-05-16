package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import com.BidQA.test.Resources.PageResources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by hishailesh77 on 5/15/2017.
 */
public class BidQaHelperClass {
    public static HashMap PostNewProject(PageResources pageResources, WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);
        DataGenerator dataGenerator = new DataGenerator();
        // To store multiple values in tabular structure
        HashMap hashMap = new HashMap();

        //Enter title
        String title = dataGenerator.randomTitleChars;



        //To use title for next test
        hashMap.put("Title",title);
        pageResources.getPostNewProjectPage().EnterProjectTitle(title);
        System.out.println("Project Title="+title);
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

        // To reuse the output (as String title)
        return hashMap;
    }

    public static void PayPal(PageResources pageResources,WebDriver driver) throws InterruptedException {
        pageResources = new PageResources(driver);
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
    }

    public static void QaLogin(PageResources pageResources,WebDriver driver){
         pageResources = new PageResources(driver);
        //Click Login button
        pageResources.getQaLoginPage().ClickLoginBtn();
        //Enter username
        pageResources.getQaLoginPage().EnterUserName();
        //Enter Password
        pageResources.getQaLoginPage().EnterPwd();
        //Click Sign Btn
        pageResources.getQaLoginPage().ClickSignBtn();
    }

    public static void QaBiddingProject(PageResources pageResources,WebDriver driver,HashMap hashMap){
        pageResources = new PageResources(driver);

        //Enter project name
        String title = (String) hashMap.get("Title");
        pageResources.getQaBiddingProjectPage().EnterProjectTitle(title);
        //Click search button
        pageResources.getQaBiddingProjectPage().ClickSearchBtn();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Click on project name
        pageResources.getQaBiddingProjectPage().ClickProjectName();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click submit proposal btn
        pageResources.getQaBiddingProjectPage().ClickSubmitProposal();
        //Enter bid amount
        pageResources.getQaBiddingProjectPage().EnterBidAmount();
        //Enter days to complete
        pageResources.getQaBiddingProjectPage().EnterDays();
        //Enter Description
        pageResources.getQaBiddingProjectPage().EnterDescription();
        //Click check box
        pageResources.getQaBiddingProjectPage().ClickChkBox();
        //Click place bid button
        pageResources.getQaBiddingProjectPage().ClickPlaceBidBtn();
    }
}
