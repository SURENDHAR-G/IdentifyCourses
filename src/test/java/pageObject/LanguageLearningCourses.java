package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.BaseClass;
import utilities.ExcelUtilityfile;

public class LanguageLearningCourses {
	public WebDriver driver;
	WebDriverWait mywait;
	
	
	
	public LanguageLearningCourses (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Locators 
	
	// Navigate to Home;
	@FindBy(xpath="//div[@class=\"header-logo-wrapper\"]/div/div/a/div/img")
	WebElement HomePage;
	
	//SearchBar for LanguageLearning
	@FindBy(className="react-autosuggest__input")
	WebElement SearchBar;
	
	//click on Search Button;
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']//*[name()='svg']")
	WebElement SearchButton;
	
	//scroll upto language;
	@FindBy(xpath="//label[contains(text(),\"Subject\")]")
	WebElement subject;
	
	//click on showmore;
	@FindBy(xpath="//button[@aria-label='Show more Subject options']//span[@class='cds-button-label'][normalize-space()='Show more']")
	WebElement ShowMore;
	
	//search for subject
	@FindBy(xpath="//input[@placeholder=\"Search for Subject\"]")
	WebElement SearchField;
	
	//click on the search button;
	@FindBy(xpath="//button[@class=\"cds-149 cds-iconButton-small cds-iconButton-primary css-1henl63\"]//*[name()=\"svg\"]")
	WebElement Searchbutton;
	
	//select the language learning;
	@FindBy(xpath="//div[@aria-label=\"Select Subject options\"]/div/label/div/span/span")
	WebElement SelectLanLearning;
	
	//click on the Apply
	@FindBy(xpath="//span[contains(text(),\"Apply\")]")
	WebElement Apply;
	
	//click on language showmore
	@FindBy(xpath="//button[@aria-label='Show more Language options']//span[@class='cds-button-label'][normalize-space()='Show more']")
	WebElement showmore;
	
	//Language list
	@FindBy(xpath="//div[@aria-label=\"Select Language options\"]/div/label/div/span")
	List<WebElement> lanlist;
	
	//click on close button;
	@FindBy(xpath="//div[@class=\"css-jyd7rb\"]/button/span")
	WebElement close;
	
	//list of level
	@FindBy(css="div[data-testid=\"search-filter-group-Level\"]>div>div>div>label>div>span")
	List<WebElement> Levellist;
	
	//Get the Text of the course count
	@FindBy(css="div[data-e2e=\"NumberOfResultsSection\"]>span")
	WebElement count;
	
	
	//Actrion Methods;
	public void HomePage() throws IOException
	{
		try {
		HomePage.click();
		}
		catch(Exception e) {}
		String[] data =ExcelUtilityfile.readExcelData("Sheet1");
		SearchBar.sendKeys(data[2]);
		SearchButton.click();
		
		
	}
	public void selectLanguageLearning() throws IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",subject);
		ShowMore.click();
		String[] data =ExcelUtilityfile.readExcelData("Sheet1");
		SearchField.sendKeys(data[3]);
		Searchbutton.click();
		SelectLanLearning.click();
		try {
			BaseClass.captureScreen("ClickOnLanLearn");
			}
			catch(Exception e)
			{
			} 
		
		Apply.click();
	}
	public void countsoflanguage() throws IOException
	{
	    List<String> Lanlist=new ArrayList<String>();
		System.out.println("----------------Language Learning counts of Each Language------------------");

		showmore.click();
		Lanlist=new ArrayList<String>();
		List<WebElement> Languagelist=lanlist;
        System.out.println("Language Count : "+Languagelist.size());
		for(WebElement list:Languagelist)
        {
        	String Language=list.getText();
        	Lanlist.add(Language);
        	String lan=Language.substring(0, Language.indexOf(" "));
        	Pattern pattern=Pattern.compile("\\d+");
        	Matcher matcher=pattern.matcher(Language);
        	String lanname = null;
        	while (matcher.find())
        	{
        		lanname=matcher.group();
        	}
        	System.out.println(lan+" : "+lanname);
        }
		close.click();
		
		System.out.println("--------------------------------------------------------------------------------");
		ExcelUtilityfile.writelanguagedata(Lanlist);

        
	}
	public void countoflevel() throws InterruptedException, IOException {
		List<String> Levlist=new ArrayList<String>();
        System.out.println("------------------Language Learning counts of different levels-------------------");
		System.out.println("Different Level Counts : "+Levellist.size());
        for(WebElement level:Levellist)
        {
        	String Levelname=level.getText();
        	Levlist.add(Levelname);
        	String lev=Levelname.substring(0, Levelname.indexOf(" "));
        Pattern pattern=Pattern.compile("\\d+");
    	Matcher matcher=pattern.matcher(Levelname);
    	String levname = null;
    	while (matcher.find())
    	{
    		levname=matcher.group();
    	}
    	System.out.println(lev+" : "+levname);
        }
		System.out.println("--------------------------------------------------------------------------------");
		ExcelUtilityfile.writeleveldata(Levlist);
		
	}
	

	
	
	

}
