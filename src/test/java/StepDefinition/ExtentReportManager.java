package StepDefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class ExtentReportManager {
 
    public static ExtentReports extent;
    static ExtentTest test;
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    public static ExtentTest createTest(String testName) {
        test = getInstance().createTest(testName);
        return test;
    }
 
    public static void createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
 
}
