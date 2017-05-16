package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/16/2017.
 */
public class ProjectProgressPage {
    WebDriver driver;

    public ProjectProgressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   /* //Define project name field
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'http://test.bidqa.com/projects/bbox/')]")
    private WebElement projectName;

    public String GetProjectName(){
        return projectName.getText();
    }*/
   //Define project in progress link
    @FindBy(how = How.XPATH, using = "//*[@id=\"my-account-admin-menu_buyer\"]/li[2]/a")
   //@FindBy(how = How.XPATH, using = "//a[@href='http://test.bidqa.com/my-account/outstanding-projects/']")
   private WebElement projectInProgressLink;

    public void ClickProjectInProgressLink(){
        projectInProgressLink.click();
    }

    //Define start work time btn field
    @FindBy(how = How.LINK_TEXT, using = "Start work timer")
    private WebElement startBtn;

    public void ClickStartBtn(){
        startBtn.click();
    }

    //Define mark delivered button
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'http://test.bidqa.com/?p_action=mark_delivered&pid=')]")
    private WebElement markDelivered;

    public void MarkDeliveredBtn(){
        markDelivered.click();
    }

    //Define Yes button
    @FindBy(how = How.XPATH, using = "//input[@value='Yes, Mark Delivered!']")
    private WebElement yesBtn;

    public void ClickYesBtn(){
        yesBtn.click();
    }
}
