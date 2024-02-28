package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.WebDevelopmentCourses;

public class Courses_Details  {
	WebDriver driver;
	public Logger logger=Hook.getLogger();
	WebDevelopmentCourses WDC=new WebDevelopmentCourses(Base.getDriver());
	@Given("user search the WebDevelopment in search bar")
	public void user_search_the_web_development_in_search_bar() throws InterruptedException, IOException {

		logger.info("------------------Search for WebDevelopment Courses --------------");
		WDC.SearchWebDevelpoment();
		
	}

	@When("user click on the webDevelopment course")
	public void user_click_on_the_web_development_course() throws InterruptedException, IOException {
		logger.info("------------------Select the WebDevelopment Skill---------------");

		WDC.clickonWebDevelopment();
		
	}

	@When("user select the English Language in Filter")
	public void user_select_the_english_language_in_filter() throws InterruptedException {
		logger.info("------------------Select the English Language---------------");

		WDC.selecttheEnglishLanguage();
		
	}

	@When("user select the Beginner Level in Filter")
	public void user_select_the_beginner_level_in_filter() throws InterruptedException {
		logger.info("------------------Select the Level of course---------------");

		WDC.selectthelevel();
		
	}

	@Then("user fetch the first two courses details")
	public void user_fetch_the_first_two_courses_details() throws InterruptedException {
	 	Thread.sleep(3000);
     	logger.info("------------------Fetching the Course details---------------");

     	WDC.CoursesDetails();
	}




}
