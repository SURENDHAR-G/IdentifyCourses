package StepDefinition;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import factory.Base;
import io.cucumber.java.AfterStep;
public class Hook {

		
		public static  WebDriver driver;
		JavascriptExecutor js;
		Properties p;
		public static Logger logger;
		@Before
		public void createdriver() throws IOException
		{
		   driver=Base.initializebrowser();
	       p=Base.getProperty();
	       
	       driver.get(p.getProperty("appURL"));
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
		}
		@Before
	    public void setUp(Scenario scenario) {
	        ExtentReportManager.createTest(scenario.getName());
	    }
		 @After
		    public void tearDown(Scenario scenario) {
		        if (scenario.isFailed()) {
		ExtentReportManager.test.fail(scenario.getName());
		//ExtentReportManager.test.fail(scenario.getThrowable());
		        } else {
		            ExtentReportManager.test.pass(scenario.getName());
		        }
		        ExtentReportManager.getInstance().flush();
		    }
		 
		
		@After
		public void tearDown()
		{
			driver.quit();
		}
		 @AfterStep
		    public void addScreenshot(Scenario scenario) {
		        
		    	// this is for cucumber junit report
		       // if( scenario.isFailed()) {
		        	
		        	TakesScreenshot ts=(TakesScreenshot) driver;
		        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
		        	scenario.attach(screenshot, "image/png","screenshot");
		        	            
		       // }
		      
		    }
		 public static Logger getLogger()
		 {
			logger=LogManager.getLogger();
			return logger;
		 }
		 
}
