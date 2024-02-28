package TestBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait mywait;
	public Logger logger;
	@BeforeClass
	@Parameters({"browser"})
	public void createdriver(String br)
	{
		logger=LogManager.getLogger(this.getClass());
		logger.info("------------------Opening the Browser---------------");
		if(br.equalsIgnoreCase("chrome"))
		{	
          driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
	   
	   driver.get("https://www.coursera.org/");
	   logger.info("------------------Launching the URL---------------");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterClass
	public void tearDown()
	{
		logger.info("------------------Closing the Browser---------------");
		driver.quit();
	}

	public static String captureScreen(String name) 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
