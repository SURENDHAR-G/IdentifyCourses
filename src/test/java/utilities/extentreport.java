package utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;
public class extentreport implements ITestListener {
	WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext testContext) {
 
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\extentreport\\" + repName);// specify location of the report
		sparkReporter.config().setDocumentTitle("IdentifyCourses Automation Report"); // Title of report
		sparkReporter.config().setReportName("IdentifyCourses Automation Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","IdentifyCourses");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		
	}
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS,result.getName()+" got successfully executed");
		try {
			String imgPath = BaseClass.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);			
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.FAIL,result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgPath = BaseClass.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);			
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());	
		try {
			String imgPath = BaseClass.captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);			
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onFinish(ITestContext testContext) {
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\extentreport\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
