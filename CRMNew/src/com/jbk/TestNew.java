package com.jbk;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ReportConfigurator;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;




public class TestNew {
public WebDriver driver=null;
public WebElement Wname;
public WebElement Wsurname;
public WebElement Wemail;
public WebElement Wphone;
public WebElement WwhatsupNo;
public String TestCName;
Write obj1=new Write();
public ExtentHtmlReporter htmlReporter;
public ExtentReports extent;
public ExtentTest test;
String aa;

@BeforeSuite
public void driverInitialize() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\javabyKiran\\Desktop\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		  driver.get("https://javabykiran.com/crmqa/admin");
			driver.manage().window().maximize();
}
			

@BeforeMethod
public void ExtentCheck() {
	htmlReporter = new ExtentHtmlReporter("C:\\Users\\javabyKiran\\Desktop\\driver\\MyReport.html");
	 extent = new ExtentReports();
	 htmlReporter.start();
	    extent.attachReporter(htmlReporter);
	
	
	  
	  //Starting the test case for reporting
	//test=report.config();
	//report.start();
	  
}
	
@AfterMethod
public void teardown() {
extent.flush();
}
@Test(priority=1)
	 public void GoToAddEnqPage() {
	test=extent.createTest("GoToAddEnqPage");
	 			 driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
	 			  "jayshree.javabykiran@gmail.com");
	 			  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(
	 			  "654321"); driver.findElement(By.
	 			  xpath("//button[@class='btn btn-primary btn-block btn-lg font-weight-medium auth-form-btn']"
	 			  )).click();
	 			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 			  driver.findElement(By.xpath("//span[normalize-space()='Enquiries']")).click();
	 			  driver.findElement(By.xpath("//a[contains(text(),'All Enquiries')]")).click();
	 			  driver.findElement(By.xpath("//button[@title='Add']")).click();	
	 			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	 			 Wname=driver.findElement(By.xpath("(//input[@id='firstName'])[1]"));
		 			Wsurname=driver.findElement(By.xpath("//form[@id='data-form']//input[@id='lastName']"));
		 			Wemail=driver.findElement(By.xpath("//form[@id='data-form']//input[@id='contactEmail']"));
		 			Wphone=driver.findElement(By.xpath("//form[@id='data-form']//input[@id='whatsappNumber']")); 
		 			WwhatsupNo=driver.findElement(By.xpath("//form[@id='data-form']//input[@id='contactNumber']"));
		 			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	

}	 
	 
@Test(priority=2,dataProvider = "ReadVariant")
public void VerifyAddEnq(String TCName,String Name,String Surname,String Email,String phone,String whatsup) {
	System.out.println(Name);
	
	
	Wname.clear();
			Wname.sendKeys(Name);
			
			Wsurname.clear();
			Wsurname.sendKeys(Surname);
			 
			Wemail.clear();
			Wemail.sendKeys(Email);
			
			Wphone.clear();
			Wphone.sendKeys(phone);
			  
			 
			WwhatsupNo.clear();
			WwhatsupNo.sendKeys(whatsup);
			driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (TCName.equals("BlankCheck")) {
			//error message code
			WebElement ErrrMsgFirstName=driver.findElement(By.xpath("//div[@id='firstName-error']"));
			  String ActualErroMsgFirstName=ErrrMsgFirstName.getText();
			 Assert.assertEquals(ActualErroMsgFirstName, "This field is required.");
          
			WebElement ErrrMsgWhatsUpNo=driver.findElement(By.xpath("//div[@id='whatsappNumber-error']"));
			  String ActualErroMsgWhatsUpNo=ErrrMsgWhatsUpNo.getText();
			 Assert.assertEquals(ActualErroMsgWhatsUpNo, "This field is required.");
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ErrrMsgContactNo=driver.findElement(By.xpath("//div[@id='contactNumber-error']"));
			  String ActualErroMsgContactNo=ErrrMsgContactNo.getText();
			 Assert.assertEquals(ActualErroMsgContactNo, "This field is required.");
			 
			WebElement ErrrMsgGender=driver.findElement(By.xpath("//div[@id='gender-error']"));
			  String ActualErroMsgGender=ErrrMsgGender.getText();
			 Assert.assertEquals(ActualErroMsgGender, "This field is required.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ErrrMsgSource=driver.findElement(By.xpath("//div[@id='source-error']"));
			  String ActualErroMsgSource=ErrrMsgSource.getText();
			 Assert.assertEquals(ActualErroMsgSource, "This field is required.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ErrrMsgCourse=driver.findElement(By.xpath("//div[@id='course-error']"));
			  String ActualErroMsgCourse=ErrrMsgCourse.getText();
			 Assert.assertEquals(ActualErroMsgCourse, "This field is required.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement ErrrMsgYearOfPassing=driver.findElement(By.xpath("//div[@id='yearOfPassing-error']"));
			  String ActualErroMsgYearOfPassing=ErrrMsgYearOfPassing.getText();
			 Assert.assertEquals(ActualErroMsgYearOfPassing, "This field is required.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("blank check done");
			
	}
	else if (TCName.equals("InvalidDataCheck")) {
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//error message code
				WebElement ErrrMsgContactEmail=driver.findElement(By.xpath("//div[@id='contactEmail-error']"));
				  String ActualErroMsgContactEmail=ErrrMsgContactEmail.getText();
				  
				 Assert.assertEquals(ActualErroMsgContactEmail, "Please enter a valid email address.");
				 System.out.println("invalid check done");
				
			}
	else if (TCName.equals("ValidData")){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement GenderSelect=driver.findElement(By.xpath("//form[@id='data-form']//select[@id='gender']")); 
		GenderSelect.click();
	   Select sel=new Select(GenderSelect); sel.selectByValue("2");
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				 WebElement SourceSelect=driver.findElement(By.xpath("//select[@id='source']"));
				 SourceSelect.click(); Select selSource=new Select(SourceSelect);
				 selSource.selectByVisibleText("Google Adwords");
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
				 WebElement CourseSelect=driver.findElement(By.xpath("//select[@id='course']"));
				 CourseSelect.click(); 
				 Select selCourse=new Select(CourseSelect);
				 selCourse.selectByValue("2"); 
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
				 WebElement PassingYearSelect=driver.findElement(By.xpath("//form[@id='data-form']//select[@id='yearOfPassing']"));
				 PassingYearSelect.click(); 
				 Select selYear=new Select(PassingYearSelect);
				 selYear.selectByValue("2014"); 
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
				 WebElement AssignedToSelect=driver.findElement(By.xpath("//select[@id='assignedTo']"));
				 AssignedToSelect.click(); 
				 Select selAssignedTo=new Select(AssignedToSelect);
				 selAssignedTo.selectByValue("17");
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
		
	}
		
	}
			

/*
 * @Test(priority=3,dataProvider = "ReadVariant") public void ReceiveData(String
 * Name,String Surname,String Email,String phone,String whatsup) {
 * System.out.println(Name);
 * 
 * Wname=driver.findElement(By.xpath("(//input[@id='firstName'])[1]"));
 * Wname.clear(); Wname.sendKeys(Name); Wsurname=driver.findElement(By.xpath(
 * "//form[@id='data-form']//input[@id='lastName']")); Wsurname.clear();
 * Wsurname.sendKeys(Surname); Wemail=driver.findElement(By.xpath(
 * "//form[@id='data-form']//input[@id='contactEmail']")); Wemail.clear();
 * Wemail.sendKeys(Email); Wphone=driver.findElement(By.xpath(
 * "//form[@id='data-form']//input[@id='whatsappNumber']")); Wphone.clear();
 * Wphone.sendKeys(phone);
 * 
 * WwhatsupNo=driver.findElement(By.xpath(
 * "//form[@id='data-form']//input[@id='contactNumber']")); WwhatsupNo.clear();
 * WwhatsupNo.sendKeys(whatsup); WebElement
 * GenderSelect=driver.findElement(By.xpath(
 * "//form[@id='data-form']//select[@id='gender']")); GenderSelect.click();
 * Select sel=new Select(GenderSelect); sel.selectByValue("2");
 * 
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); WebElement
 * SourceSelect=driver.findElement(By.xpath("//select[@id='source']"));
 * SourceSelect.click(); Select selSource=new Select(SourceSelect);
 * selSource.selectByVisibleText("Google Adwords");
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); WebElement
 * CourseSelect=driver.findElement(By.xpath("//select[@id='course']"));
 * CourseSelect.click(); Select selCourse=new Select(CourseSelect);
 * selCourse.selectByValue("2"); driver.manage().timeouts().implicitlyWait(20,
 * TimeUnit.SECONDS); WebElement PassingYearSelect=driver.findElement(By.xpath(
 * "//form[@id='data-form']//select[@id='yearOfPassing']"));
 * PassingYearSelect.click(); Select selYear=new Select(PassingYearSelect);
 * selYear.selectByValue("2014"); driver.manage().timeouts().implicitlyWait(20,
 * TimeUnit.SECONDS); WebElement
 * AssignedToSelect=driver.findElement(By.xpath("//select[@id='assignedTo']"));
 * AssignedToSelect.click(); Select selAssignedTo=new Select(AssignedToSelect);
 * selAssignedTo.selectByValue("17");
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).
 * click(); WebElement
 * ErrrMsgFirstName=driver.findElement(By.xpath("//div[@id='firstName-error']"))
 * ; String ActualErroMsgFirstName=ErrrMsgFirstName.getText();
 * Assert.assertEquals(ActualErroMsgFirstName, "This field is required.");
 * 
 * }
 */
@DataProvider 
public Object[][] ReadVariant() throws IOException {
  
  
  Object[][] arrObj = ExcelReadCRM.readExcel((ExcelReadCRM.Filepath),0); 
  return (arrObj); }
 
		
		
/*
 * @DataProvider public Object[][] oneRowRead() throws IOException {
 * 
 * 
 * Object[][] arrObj =
 * ExcelReadCRM.readExcelFirstRow((ExcelReadCRM.Filepath),0); return (arrObj); }
 */
	
		
		
		
	
}
