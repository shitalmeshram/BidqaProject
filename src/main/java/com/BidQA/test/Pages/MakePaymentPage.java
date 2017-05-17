package com.BidQA.test.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by hishailesh77 on 5/16/2017.
 */
public class MakePaymentPage {
    WebDriver driver;

    public MakePaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Define awaiting completion Link
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/my-account/awaiting-completion/']")
    private WebElement awaitingLink;

    //Define awaiting completion Link Method
    public void ClickAwaitingLink()
    {
        awaitingLink.click();
    }
    //Define yes mark completed btn
    @FindBy(how= How.XPATH, using="//input[@value='Yes, Mark Completed!']")
    private WebElement yesMarkBtn;

    //Defineyes mark completed  Method
    public void ClickYesMarkBtn()
    {
        yesMarkBtn.click();
    }
    //Define make Escrow btn
    @FindBy(how= How.XPATH, using="//a[@href='http://test.bidqa.com/my-account/finances/?redir1=&pg=escrow']")
    private WebElement escrowBtn;

    //Defineyes mark completed  Method
    public void ClickEscrowBtn()
    {
        escrowBtn.click();
    }

    //Define  Escrow amount
    @FindBy(how= How.XPATH, using="//input[@id='amount']")
    private WebElement enterAmount;

    //Define Escrow amount  Method
    public void EnterEscrowAmount()
    {
        enterAmount.clear();
        enterAmount.sendKeys("5");
    }
    /*//Define  Escrow for project
    @FindBy(how= How.XPATH, using="//select[@name='projectss']")
    private WebElement selectProject;

    //Select Escrow for project  from dropdown
    public void SelectEscrowForProject(String title) throws InterruptedException {
        Select project = new Select(selectProject);
        project.selectByVisibleText(title);
        System.out.println("Project Name ="+title);
        Thread.sleep(2000);*/

    //Define  Escrow for Qa Engineer
   /* @FindBy(how= How.XPATH, using="/*//*[@id=win_providers]/input")
    private WebElement enterQaName;

    //Define Escrow for Qa Engineer  Method
    public void EnterQaName()
    {
    enterQaName.sendKeys("minnie");
    }*/

    //Define Make Escrow Btn
    @FindBy(how= How.XPATH, using="//input[@name='escrowme']")
    private WebElement makeEscrowBtn;

    //Define Make Escrow Btn  Method
    public void ClickMakeEscrowBtn()
    {
        makeEscrowBtn.click();
    }

    //Define Finance Link
    @FindBy(how= How.XPATH, using="//ul[@id='my-account-admin-menu']//a[@href='http://test.bidqa.com/my-account/finances/']")
    private WebElement financeLink;

    //Define Finance Link  Method
    public void ClickFinanceLink()
    {
        financeLink.click();
    }
    //Define 'Payment transactions' completed
    @FindBy(how= How.XPATH, using="//div[@class='box_title']")
    private WebElement textPresent;

    public String GetPaymentTransactionText(){
        return textPresent.getText();
    }
}
