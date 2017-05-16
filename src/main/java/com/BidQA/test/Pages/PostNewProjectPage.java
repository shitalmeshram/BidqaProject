package com.BidQA.test.Pages;

import com.BidQA.test.Data.DataGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by shail on 5/10/2017.
 */
public class PostNewProjectPage {
    WebDriver driver;
    DataGenerator dataGenerator = new DataGenerator();
    //String title = dataGenerator.randomTitleChars;


    public PostNewProjectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
   /* public WebElement enterProTitle(){
        return driver.findElement(By.xpath("//input[@name='project_title']"));
    }*/

    //Define project title
    @FindBy(how= How.XPATH, using="//input[@name='project_title']")
    private WebElement enterProTitle;

    //Define project title Method
    public void EnterProjectTitle()
    {
      enterProTitle.sendKeys(dataGenerator.randomTitleChars);
        //return enterProTitle;

    }
    //Define description
    @FindBy(how= How.XPATH, using="//textarea[@name='project_description']")
    private WebElement enterDescription;

    //Define description Method
    public void EnterDescription()
    {
        enterDescription.sendKeys(dataGenerator.randomDescription);
    }
    //Define select category
    @FindBy(how= How.XPATH, using="//input[@value='2'][@name='project_cat_cat_multi[]']")
    private WebElement selectCategory;

    //Define select category Method
    public void SelectCategory()
    {
        System.out.println("Select the category");
       selectCategory.click();
    }

    //Define Tags
    @FindBy(how= How.XPATH, using="//input[@name='project_tags']")
    private WebElement enetrTag;

    //Define select category Method
    public void EnterTag()
    {
        enetrTag.sendKeys(dataGenerator.randomTagsChars);
    }

    //Define select skills
    @FindBy(how= How.XPATH, using="//input[@value='38'][@name='project_skill_cat_multi[]']")
    private WebElement selectSkills;

    //Define select category Method
    public void SelectSkills()
    {
        System.out.println("Select skill");
        selectSkills.click();
    }

    //Define price budget
    @FindBy(how= How.XPATH, using="//select[@name='budgets']")
    private WebElement selectBudget;

    //Define select budget drop down
    public void SelectBudget() throws InterruptedException {
        Select budget = new Select(selectBudget);
        budget.selectByIndex(1);
        Thread.sleep(2000);
    }

    //Define project ending
    @FindBy(how= How.XPATH, using="//input[@id='ending']")
    private WebElement endDate;

    //Define project ending method
    public void EnterEndDate(){
        endDate.click();
    }
    //Define pick a date
    @FindBy(how= How.LINK_TEXT, using="31")
    private WebElement selectDate;

    //Define pick a date method
    public void SelectDate(){
        selectDate.click();
    }

    //Define Country Field
    @FindBy(how = How.XPATH, using = "//select[@id='do_input_new']")
    private WebElement selectCountry;

    //Select Country from drop down
    public void SelectCountry() throws InterruptedException {
        Select country = new Select(selectCountry);
        country.selectByVisibleText("Austria");
        System.out.println("Country = Austria");
        Thread.sleep(2000);
    }

    //Define State Field
    @FindBy(how = How.XPATH, using = "//select[@name='subloc']")
    private WebElement selectState;

    //Select Country from drop down
    public void SelectState() throws InterruptedException {
        Select state = new Select(selectState);
        state.selectByVisibleText("Salzburg");
        System.out.println("State = Salzburg");
        Thread.sleep(2000);
    }

    //Define Address
    @FindBy(how= How.XPATH, using="//input[@name='project_location_addr']")
    private WebElement enterAddress;

    //Define Address method
    public void EnterAddress(){
        enterAddress.sendKeys(dataGenerator.addressChars);
    }

    //Define next button1
    @FindBy(how = How.XPATH, using = "//input[@name='project_submit1']")
    private WebElement nextBtn1;

    //Define next button1 method
    public void ClickNextBtn1(){
        nextBtn1.click();
    }

    //Define next button2
    @FindBy(how = How.XPATH, using = "//input[@name='project_submit2']")
    private WebElement nextBtn2;

    //Define next button method
    public void ClickNextBtn2(){
        nextBtn2.click();
    }

    //Define next button3
    @FindBy(how = How.LINK_TEXT, using = "Next Step →")
    private WebElement nextBtn3;

    //Define next button method
    public void ClickNextBtn3(){
        nextBtn3.click();
    }

    //Define payment terms
    @FindBy(how = How.XPATH, using = "//input[@name='payment-condition']")
    private WebElement chkBox;

    //Define payment terms method
    public void ClickchkBox(){
        chkBox.click();
    }
    //Define paypal button
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'http://test.bidqa.com/?p_action=paypal_listing&pid')]")
    //@FindBy(how = How.LINK_TEXT, using = "Pay by PayPal")
    private WebElement paypalBtn;

    //Define paypal button method
    public void ClickPaypalBtn(){
        paypalBtn.click();
    }

}
