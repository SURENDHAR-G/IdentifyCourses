package StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.ErrorMessage;

public class form_filling {
    WebDriver driver;
    public Logger logger=Hook.getLogger();
	ErrorMessage EM=new ErrorMessage(Base.getDriver());
	@Given("user naviagte to the form")
	public void user_naviagte_to_the_form() throws InterruptedException {
		logger.info("------------------Navigate to the form ---------------");

		EM.navigateToForm();
		
		}

	@Then("user filling the form")
	public void user_filling_the_form() throws InterruptedException, IOException {
		logger.info("------------------Filling the form---------------");

		EM.FormFilling();
}
}
