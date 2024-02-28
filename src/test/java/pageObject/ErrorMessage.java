package pageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.BaseClass;
import utilities.ExcelUtilityfile;
public class ErrorMessage{
	public WebDriver driver;
	public ErrorMessage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    //Loctaors
	
	//
	@FindBy(xpath="//div[@class=\"header-logo-wrapper\"]/div/div/a/div/img")
	WebElement HomePage;
	
	@FindBy(linkText="For Enterprise")
	WebElement Enterprise;	
	
	@FindBy(xpath="//a[contains(text(),'Solutions')]")
	WebElement Solution;
	
	@FindBy(xpath="//div[@class=\"css-1l4mih3\"]/div[2]/a")
	WebElement ClickonCampus;
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Phone")
	WebElement Phone;
	
	@FindBy(id="Institution_Type__c")
	WebElement institution;
	
	@FindBy(id="Company")
	WebElement Company;
	
	@FindBy(id="Title")
	WebElement Role;
	
	@FindBy(id="Department")
	WebElement Department;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c")
	WebElement Coursera;
	
	@FindBy(id="Country")
	WebElement Country;
	
	@FindBy(id="Self_reported_employees_to_buy_for__c")
	WebElement Self_reported;
	
	@FindBy(id="State")
	WebElement State;
	
	@FindBy(css="button[type=\"submit\"]")
	WebElement submit;
	
	@FindBy(id="ValidMsgEmail")
	WebElement ErrorMsg;
	
	
	//Action Methods
	public void navigateToForm() throws InterruptedException
	{
		try {
		HomePage.click();
		}
		catch(Exception e) {}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-100)");
		try {
			BaseClass.captureScreen("ClickOnEnterprise");
			}
			catch(Exception e)
			{
						} 
		
		Enterprise.click();
		Thread.sleep(3000);
		Solution.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,100)");
		ClickonCampus.click();
		js.executeScript("window.scrollBy(0,4300)");
	}
	public void FormFilling() throws InterruptedException, IOException
	{
		String[] data =ExcelUtilityfile.readExcelData("Sheet1");
		FirstName.sendKeys(data[4]);
		LastName.sendKeys(data[5]);
		Email.sendKeys(data[6]);
		Phone.sendKeys(data[7]);
		
		Select select=new Select(institution);
		select.selectByVisibleText("2 Year College");
		
		Company.sendKeys(data[8]);
		
		Select select1=new Select(Role);
		select1.selectByVisibleText("Vice-President/Vice-Provost");
		
		Department.sendKeys(data[9]);
		try {
			BaseClass.captureScreen("FormFilling");
			}
			catch(Exception e)
			{
				
			} 
	
		Select select2=new Select(Coursera);
		select2.selectByVisibleText("Meet with Coursera Sales Team");
		
		Select select3=new Select(Country);
		select3.selectByVisibleText("India");
		
		Select select4=new Select(Self_reported);
		select4.selectByVisibleText("5-25");
		
		Select select5=new Select(State);
		select5.selectByVisibleText("Tamil Nadu");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		submit.click();
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView(true);",FirstName);
		String Errormsg=ErrorMsg.getText();
		System.out.println("Error Message : "+Errormsg);
		Thread.sleep(2000);
		try {
			BaseClass.captureScreen("ErrorMessage");
			}
			catch(Exception e)
			{
				
			} 
	}

}
