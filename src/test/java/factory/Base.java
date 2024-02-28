package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	static WebDriver driver;
	static Properties p;
	
	public static WebDriver initializebrowser() throws IOException
	{
		    
		if(getProperty().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if (getProperty().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperty().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperty().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	       
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else if(getProperty().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperty().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 	 
			 return driver;
	
	
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static Properties getProperty() throws IOException
	{
		 FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configure.properties");
		 p=new Properties();
		 p.load(file);
		 return p;
		 
	}

}
