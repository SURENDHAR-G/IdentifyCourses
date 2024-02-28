package TestCases;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pageObject.ErrorMessage;
import pageObject.LanguageLearningCourses;
import pageObject.WebDevelopmentCourses;

class IdentifyCourses extends BaseClass
{
	//WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
	//LanguageLearningCourses LLC=new LanguageLearningCourses(driver);
	//ErrorMessage EM=new ErrorMessage(driver);


	@Test(priority=0)
	public void Select_the_WebDevelopment_Skill() throws InterruptedException, IOException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
	    logger.info("------------------Search for WebDevelopment Courses --------------");
		WDC.SearchWebDevelpoment();
		//Thread.sleep(3000);
		logger.info("------------------Select the WebDevelopment Skill---------------");
		WDC.clickonWebDevelopment();
		
	}
	@Test(priority=1)
	public void Select_the_English_And_Beginner() throws InterruptedException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		//Thread.sleep(4000);
		logger.info("------------------Select the English Language---------------");
		WDC.selecttheEnglishLanguage();
		//Thread.sleep(4000);
		logger.info("------------------Select the Level of course---------------");
		WDC.selectthelevel();
		
	}
	@Test(priority=2)
	public void Fetch_the_Course_Details() throws InterruptedException, IOException
	{
		WebDevelopmentCourses WDC=new WebDevelopmentCourses(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
     	js.executeScript("window.scrollBy(0,-700)");
     	Thread.sleep(3000);
     	logger.info("------------------Fetching the Course details---------------");
     	WDC.CoursesDetails();
	}
	@Test(priority=3)
	public void Select_the_LanguageLearning_skill() throws IOException, InterruptedException
	{
		LanguageLearningCourses LLC=new LanguageLearningCourses(driver);

		logger.info("------------------Navigate to home page---------------");
		LLC.HomePage();
        Thread.sleep(3000);
        logger.info("------------------Select the Language learning Subject---------------");
		LLC.selectLanguageLearning();
	}
	@Test(priority=4)
	public void Fetch_Language_and_Level_counts() throws InterruptedException, IOException
	{
		LanguageLearningCourses LLC=new LanguageLearningCourses(driver);

		Thread.sleep(5000);
		logger.info("------------------Fetching the Language Counts---------------");
		LLC.countsoflanguage();
		logger.info("------------------Fetching the Level Counts---------------");
		LLC.countoflevel();
	}
	@Test(priority=5)
	public void navigate_to_the_form() throws InterruptedException
	{
		ErrorMessage EM=new ErrorMessage(driver);

		logger.info("------------------Navigate to the form ---------------");
		EM.navigateToForm();
	}
	@Test(priority=6)
	public void CaptureErrorMessage() throws InterruptedException, IOException
	{
		ErrorMessage EM=new ErrorMessage(driver);

		
		logger.info("------------------Filling the form---------------");
		EM.FormFilling();
		
	}
	


}


	