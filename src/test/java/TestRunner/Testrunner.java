package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//FeatureFile/"},
		glue="StepDefinition",
				plugin= {"pretty", "html:reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  },
		
		dryRun=false,
		monochrome=true,
		publish=true
		//tags="@Sanity"
//		tags="@Smoke"
//		tags="@regression"
		)
public class Testrunner {

	
	
}