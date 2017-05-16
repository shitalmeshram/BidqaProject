package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hishailesh77 on 5/15/2017.
 */
public class QaBiddingProjectPage {
    WebDriver driver;
    DataGenerator dataGenerator = new DataGenerator();

    public QaBiddingProjectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define Enter project name field
    @FindBy(how= How.XPATH, using="//input[@id='my-top-search-input']")
    private WebElement enterProjectName;

    public void EnterProjectTitle(String title){
        enterProjectName.sendKeys(title);
    }

    //Define search field
    @FindBy(how= How.XPATH, using="//input[@id='my-top-submit-input']")
    private WebElement searchBtn;

    public void ClickSearchBtn(){
        searchBtn.click();
    }
    //Define project name field
    @FindBy(how= How.XPATH, using="//a[contains(@href,'http://test.bidqa.com/projects/bbox/')]")
    private WebElement projectName;

    public void ClickProjectName(){
        projectName.click();
    }
    //Define submit proposal field
    @FindBy(how= How.XPATH, using="//a[@id='submit-proposal-id']")
    private WebElement submitProposal;

    public void ClickSubmitProposal(){
        submitProposal.click();
    }
    //Define your bid field
    @FindBy(how= How.XPATH, using="//input[@id='bid']")
    private WebElement bidAmount;

    public void EnterBidAmount(){
        bidAmount.clear();
        bidAmount.sendKeys("3");
    }
    //Define days to complete field
    @FindBy(how= How.XPATH, using="//input[@id='days_done']")
    private WebElement daysComplete;

    public void EnterDays(){
        daysComplete.clear();
        daysComplete.sendKeys("10");
    }
    //Define description field
    @FindBy(how= How.XPATH, using="//textarea[@name='description2']")
    private WebElement enterDescription;

    public void EnterDescription(){
        enterDescription.sendKeys(dataGenerator.descriptionChars);
    }
    //Define checkbox field
    @FindBy(how= How.XPATH, using="//input[@id='submits_crt_check']")
    private WebElement chkBox;

    public void ClickChkBox(){
        chkBox.click();
    }
    //Define place bid button field
    @FindBy(how= How.XPATH, using="//input[@id='submits_crt']")
    private WebElement placeBidBtn;

    public void ClickPlaceBidBtn(){
        placeBidBtn.click();
    }
    //define status field
    @FindBy(how= How.TAG_NAME, using="h3")
    private WebElement statusText;

    public String GetStatusText(){
        return statusText.getText();
    }

    //Define ok btn
    @FindBy(how= How.XPATH, using="//span[@id='notification_ok']")
    private WebElement okBtn;

    public void ClickOkBtn(){
        okBtn.click();
    }
}
