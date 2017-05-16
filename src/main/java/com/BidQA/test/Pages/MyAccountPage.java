package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shail on 5/10/2017.
 */
public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Define post new project link
    @FindBy(how= How.LINK_TEXT, using="Post New Project")
    private WebElement postNewProLink;

    //Define Register Button Click Method
    public void ClickPostNewProLink()
    {
        postNewProLink.click();
    }

    @FindBy(how= How.TAG_NAME, using="h3")
    private WebElement projectText;

    public String GetProjectText(){
        return projectText.getText();
    }

    @FindBy(how= How.XPATH, using="//li[@class='user_type']")
    private WebElement textPresent;

    public String GetPresentText(){
        return textPresent.getText();
    }

}
