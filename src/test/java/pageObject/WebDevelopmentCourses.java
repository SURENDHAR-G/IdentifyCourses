package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.BaseClass;
import utilities.ExcelUtilityfile;
public class WebDevelopmentCourses{
	public WebDriver driver;
	public WebDevelopmentCourses(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators ;
	//Searchbar to search the WebDevelopment;
	@FindBy(css=("input[placeholder=\"What do you want to learn?\"]"))
	WebElement SearchBar;
	
	//click on search button;
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']//*[name()='svg']")
	WebElement SearchButton;
	
	//scrolldown upto skill WebElement;
	@FindBy(xpath="//label[contains(text(),'Skills')]")
	WebElement Skill;
	
	// click on showmore button;
	@FindBy(xpath="//button[@aria-label='Show more Skills options']//span[@class='cds-button-label'][normalize-space()='Show more']")
	WebElement ShowMore;
	
	//Search the WebDevelopment skill;
	@FindBy(xpath="//input[@placeholder=\"Search for Skills\"]")
	WebElement SearchforSkill;
	
	//click on the search button;
	@FindBy(xpath="//button[@class=\"cds-149 cds-iconButton-small cds-iconButton-primary css-1henl63\"]//*[name()='svg']")
	WebElement clickonbutton;
	
	//list of WebDevelopment;
	@FindBy(xpath="//div[@id=\"checkbox-group\"]/div/label/div/span/span[contains(text(),\"Web Development\")]")
	List<WebElement> listofWebDevelopment;
	
	//click on apply button;
	@FindBy(xpath="//span[contains(text(),\"Apply\")]")
	WebElement clickonApply;
	
	//scrolldown upto language;
	@FindBy(xpath="//label[contains(text(),\"Language\")]")
	WebElement language;
	
	//Select the english Language;
	@FindBy(xpath="//div[@data-testid=\"search-filter-group-Language\"]/div/div[2]/div[@data-testid=\"English-false\"]/label/span")
	WebElement clickonenglish;
	
	//scroll upto level;
	@FindBy(xpath="//label[contains(text(),\"Level\")]")
	WebElement level;
	
	//select the beginner level;
	@FindBy(xpath="//span[contains(text(),\"Beginner\")]")
	WebElement Beginner;
	
	//list of courses;
	@FindBy(xpath="//div[@class=\"cds-9 css-0 cds-11 cds-grid-item cds-56 cds-81\"]/ul/li")
	List<WebElement> CourseList;
	
	//fetch the course name;
	@FindBy(xpath="//section[@class=\"css-oe48t8\"]/div/div/div/div/section/h1")
	WebElement Coursename;
	
	//fetch the course Duration
	@FindBy(xpath="//section[@class=\"css-oe48t8\"]/div/div/div[2]/div/div/section/div[2]/div[3]/div[1]")
	WebElement Courseduration;
	
	//fetch the course rating
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]")
	WebElement Courserating;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[1]/div[1]/section/div/div/h1")
	WebElement coursename;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[2]/section/div/div[3]/div/div/div[1]")
	WebElement courseduration;
	
	@FindBy(xpath="//*[@id=\"rendered-content\"]/div/main/section[2]/div/div/div[2]/section/div/div[1]/div/div/div[1]")
	WebElement courserating;
	
	
	//Action Methods
	public void SearchWebDevelpoment() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		String[] data =ExcelUtilityfile.readExcelData("Sheet1");
		SearchBar.sendKeys(data[0]);
		SearchButton.click();
	}
	public void clickonWebDevelopment() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Skill);
		ShowMore.click();
		//String[] data =ExcelUtilityfile.readExcelData("Sheet1");
		//SearchforSkill.sendKeys(data[1]);
		Thread.sleep(3000);
		//clickonbutton.click();
		for(int i=0;i<listofWebDevelopment.size();i++)
		{
			String WebEle=listofWebDevelopment.get(i).getText();
			int length=WebEle.length();
			if(WebEle.equalsIgnoreCase("Web Development") || length==15 )
			{
				listofWebDevelopment.get(i).click();
			}
			else if(WebEle.equalsIgnoreCase("Web Development (230)")|| length==21)
			{
				listofWebDevelopment.get(i).click();
			}
		}
		try {
		BaseClass.captureScreen("ClickOnWebDev"); 
		}
		catch(Exception e)
		{
			
		}
		clickonApply.click();
	}
	public void selecttheEnglishLanguage() throws InterruptedException 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",language);
		js.executeScript("window.scrollBy(0,-100)");
		
		clickonenglish.click();
		Thread.sleep(2000);
		try {
			BaseClass.captureScreen("ClickOnEng"); 
			}
			catch(Exception e)
			{
				
			} 
		
	}
	public void selectthelevel() throws InterruptedException 
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",level);
		js.executeScript("window.scrollBy(0,-100)");
		 
		Beginner.click();
		Thread.sleep(2000);
		try {
			BaseClass.captureScreen("ClickOnWebBig"); 
			}
			catch(Exception e)
			{
				
			}
		
		
     	js.executeScript("window.scrollBy(0,-700)");
		
	}
	public void CoursesDetails() throws InterruptedException
	{
		List<WebElement> course=CourseList;
		for(int i=0;i<2;i++)
		{
			course.get(i).click();
			if(i==0)
			{
				try {
					Set<String> winid=driver.getWindowHandles();
					List<String> WinId=new ArrayList<String>(winid);
					driver.switchTo().window(WinId.get(1));
					Thread.sleep(3000);
					String CourseName=Coursename.getText();
					String CourseDuration=Courseduration.getText();
					String CourseRating=Courserating.getText();
					System.out.println("-----------------Course No:1------------------");
					System.out.println("CourseName : "+CourseName);
					System.out.println("CourseDuration : "+CourseDuration);
					System.out.println("CourseRating : "+CourseRating);
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
					try {
						BaseClass.captureScreen("CourseNo1"); 
						}
						catch(Exception e)
						{
							
						} 
					driver.switchTo().window(WinId.get(0));
					Thread.sleep(2000);
					
				
				}
				catch(Exception e) {
					Set<String> winid=driver.getWindowHandles();
					List<String> WinId=new ArrayList<String>(winid);
					driver.switchTo().window(WinId.get(1));
					Thread.sleep(2000);
					String CourseName=coursename.getText();
					Thread.sleep(2000);
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,100)");
					Thread.sleep(2000);
					String CourseDuration=courseduration.getText();
					String CourseRating=courserating.getText();
					System.out.println("-----------------Course No:1------------------");
					System.out.println("Coursename : "+CourseName);
					System.out.println("Courseduration : "+CourseDuration);
					System.out.println("Courserating : "+CourseRating);
					System.out.println("----------------------------------------------");
					Thread.sleep(3000);
					try {
						BaseClass.captureScreen("CourseNo1"); 
						}
						catch(Exception e1)
						{
							
						} 
					driver.switchTo().window(WinId.get(0));
					Thread.sleep(3000);
				
						}

				}
				
			
			
			else 
			{
				try {
					Set<String> winid=driver.getWindowHandles();
					List<String> WinId=new ArrayList<String>(winid);
					driver.switchTo().window(WinId.get(2));
					Thread.sleep(2000);
					String CourseName=coursename.getText();
					Thread.sleep(2000);
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,100)");
					Thread.sleep(2000);
					String CourseDuration=courseduration.getText();
					String CourseRating=courserating.getText();
					System.out.println("-----------------Course No:2------------------");
					System.out.println("coursename : "+CourseName);
					System.out.println("courseduration : "+CourseDuration);
					System.out.println("courserating : "+CourseRating);
					System.out.println("----------------------------------------------");
					Thread.sleep(2000);
					try {
						BaseClass.captureScreen("CourseNo2"); 
						}
						catch(Exception e)
						{
							
						} 
					driver.switchTo().window(WinId.get(0));
					Thread.sleep(2000);
				
				}
				catch(Exception e) {
				Set<String> winid=driver.getWindowHandles();
				List<String> WinId=new ArrayList<String>(winid);
				driver.switchTo().window(WinId.get(2));
				Thread.sleep(2000);
				String CourseName=Coursename.getText();
				String CourseDuration=Courseduration.getText();
				String CourseRating=Courserating.getText();
				System.out.println("-----------------Course No:2------------------");
				System.out.println("CourseName : "+CourseName);
				System.out.println("CourseDuration : "+CourseDuration);
				System.out.println("CourseRating : "+CourseRating);
				System.out.println("----------------------------------------------");
				Thread.sleep(2000);
				try {
					BaseClass.captureScreen("CourseNo2"); 
					}
					catch(Exception e1)
					{
					}
				driver.switchTo().window(WinId.get(0));}
			}
		}
	}
}
