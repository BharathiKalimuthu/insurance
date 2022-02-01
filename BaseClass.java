package insurance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeSuite
	public void setExtent() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
	
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Tripzumi Insurance");
		htmlReporter.config().setTheme(Theme.DARK);
	
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjestName", "Insurane");
		extent.setSystemInfo("Tester", "Bharathi");
		extent.setSystemInfo("OS", "Ubuntu");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://b2cui2.tltid.com/pa");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " - Test case failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ " - Test case failed", ExtentColor.RED));	
		
			String pathString=BaseClass.screenShot(driver,result.getName());
			test.addScreenCaptureFromPath(pathString);
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is :"+result.getName());	
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Skipped Test case is :"+result.getName());	
		}
		driver.close();
		
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\ScreenShot\\"+ filename+".png";
		File finalDestination=new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		}catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}

}
