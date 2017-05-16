package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hishailesh77 on 5/16/2017.
 */
public class SelectWinnerPage {
    WebDriver driver;

    public SelectWinnerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Define project name field
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'http://test.bidqa.com/projects/bbox/')]")
    private WebElement clickProject;

        public void ClickProjectName(){
        clickProject.click();
    }
    //Define select as winner field
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'http://test.bidqa.com/?p_action=choose_winner&pid=')]")
    private WebElement selectWinner;

        public void ClickSelectWinner(){
        selectWinner.click();
    }

    //Define choose a winner btn
    @FindBy(how = How.XPATH, using = "//input[@name='yes']")
    private WebElement winnerBtn;

     public void ChooseWinnerBtn(){
        winnerBtn.click();
    }

    //define status field
   // @FindBy(how= How.XPATH, using="//i[@class='bid-flag']")
    @FindBy(how= How.XPATH, using=".//*[@id='my_bids']/div/div[5]")
    private WebElement statusText;

    public String GetStatus(){
        return statusText.getText();
    }
}
