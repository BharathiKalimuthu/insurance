package org.insurance;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import insurance.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyInsuarnce extends BaseClass{
	WebDriver driver;
	@Test
	public void applyinsurance() {
		test=extent.createTest("applyinsurance");
		setup();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//li[3]/a/a/span/span[2]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[contains(.,'Passenger Type')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[contains(.,'Adult')])[2]")).click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.click();
		firstName.sendKeys("ram");
	
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastName.click();
		lastName.sendKeys("kumar");
		
		driver.findElement(By.xpath("//input[@placeholder='Date Of Birth']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement dobYear = driver.findElement(By.xpath("//input[@type='number']"));
		dobYear.click();
		dobYear.sendKeys("1998");
		//////////////
		
		driver.findElement(By.xpath("//span[@aria-label='January 12, 1998']")).click();
		
		WebElement fare = driver.findElement(By.xpath("//input[@placeholder='Fare']"));
		fare.click();
		fare.sendKeys("450");
		
		WebElement fromCity = driver.findElement(By.xpath("//input[@placeholder='From']"));	
		fromCity.click();
		fromCity.sendKeys("yyz");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@data-value='Toronto (YYZ)']")).click();
		
		WebElement toCity = driver.findElement(By.xpath("//input[@placeholder='To']"));	
		toCity.click();
		toCity.sendKeys("dxb");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@data-value='Dubai (DXB)']")).click();
		
		
		driver.findElement(By.xpath("(//input[@placeholder='Departure Date'])[1]")).click();
		driver.findElement(By.xpath("(//div[@date='2022-01-31'])[1]")).click();
		
		driver.findElement(By.xpath("//span[contains(.,'State/Province Of Residence')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//span[contains(.,'Alberta')])[2]")).click();
		
		driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();
		
		
		///////// next page
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[contains(.,'Book Now')])[1]")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		
		WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
		fullName.click();
		fullName.sendKeys("ram kumar");
		
		WebElement contactNumber = driver.findElement(By.xpath("//input[@placeholder='Contact Number']"));
		contactNumber.click();
		contactNumber.sendKeys("9876567898");
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.click();
		email.sendKeys("ramkumar54@gmail.com");
		
		WebElement address = driver.findElement(By.xpath("//input[@placeholder='Address Line 1']"));
		address.click();
		address.sendKeys("chennai");
		js.executeScript("window.scrollBy(0,4"+ "50)", "");
		
		
		driver.findElement(By.xpath("//span[contains(.,'Country')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement( By.xpath("(//span[contains(.,'India')])[7]")).click();
		
//		WebElement state = driver.findElement(By.xpath("//span[contains(.,'State / Province')]"));
//		state.click();
//		state.sendKeys("Tamil Nadu");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("(//span[contains(.,'Tamil Nadu')])[3]")).click();
//		Select select=new Select(state);
//		select.selectByVisibleText("Tamil Nadu");
		
		WebElement cithName = driver.findElement(By.xpath("//input[@placeholder='City']"));
		cithName.click();
		cithName.sendKeys("Chennai");
		
		WebElement pinCode = driver.findElement(By.xpath("//input[@placeholder='Postal / Zip Code']"));
		pinCode.click();
		pinCode.sendKeys("600097");
		
		driver.findElement(By.xpath("//label[contains(.,'I accept that I belong to the selected province')]")).click();
		driver.findElement(By.xpath("//span[contains(.,' By completing this booking, I agree to the')]")).click();
		
	}
}
