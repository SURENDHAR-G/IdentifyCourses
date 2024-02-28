package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LanguageLearningCourses;
  

public class Language_Learning_courses {
	  WebDriver driver;
	  public Logger logger=Hook.getLogger();
    
	LanguageLearningCourses LLC=new LanguageLearningCourses(Base.getDriver());

@Given("navigate to the home page")
public void navigate_to_the_home_page() throws InterruptedException, IOException {
	
	Thread.sleep(3000);
	logger.info("------------------Navigate to home page---------------");

	LLC.HomePage();	
}

@When("select the Language Learning Subject")
public void select_the_language_learning_subject() throws IOException, InterruptedException {
	 Thread.sleep(3000);
     logger.info("------------------Select the Language learning Subject---------------");

	LLC.selectLanguageLearning();
}

@Then("fetch the language learning counts")
public void fetch_the_language_learning_counts() throws InterruptedException, IOException {
	Thread.sleep(5000);
	logger.info("------------------Fetching the Language Counts---------------");

	LLC.countsoflanguage();
}

@Then("fetch the different level counts")
public void fetch_the_different_level_counts() throws InterruptedException, IOException {
	logger.info("------------------Fetching the Level Counts---------------");

	LLC.countoflevel();
}
}
