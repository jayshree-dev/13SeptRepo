package com.jbk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEnquiryFunctionality {

	 public static  WebDriver driver;
	 public static WebElement ele;
	  public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\javabyKiran\\Desktop\\set\\chromedriver.exe");
		driver=new ChromeDriver();
		  driver.get("https://javabykiran.com/crmqa/admin");
			driver.manage().window().maximize();
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
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				
				  driver.findElement(By.xpath("(//input[@id='firstName'])[1]")).sendKeys("TestAuto");
				  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				  driver.findElement(By.xpath("//form[@id='data-form']//input[@id='lastName']")
				 ).sendKeys("TestAuto"); 
				  driver.findElement(By.xpath(
				  "//form[@id='data-form']//input[@id='contactEmail']")).sendKeys(
				  "jayshree.chaudhari30@gmail.com"); 
				  driver.findElement(By.xpath(
				  "//form[@id='data-form']//input[@id='whatsappNumber']")).sendKeys(
				  "0000000001"); 
				  driver.findElement(By.xpath(
				  "//form[@id='data-form']//input[@id='contactNumber']")).sendKeys("0000000002"
				  ); 
				  WebElement GenderSelect=driver.findElement(By.xpath(
				  "//form[@id='data-form']//select[@id='gender']")); 
				  GenderSelect.click();
				  Select sel=new Select(GenderSelect); sel.selectByValue("2");
				 
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          WebElement SourceSelect=driver.findElement(By.xpath("//select[@id='source']"));
	          SourceSelect.click();
	          Select selSource=new Select(SourceSelect);
	          selSource.selectByVisibleText("Google Adwords");
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          WebElement CourseSelect=driver.findElement(By.xpath("//select[@id='course']"));
	          CourseSelect.click();
	          Select selCourse=new Select(CourseSelect);
	          selCourse.selectByValue("2");
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          WebElement PassingYearSelect=driver.findElement(By.xpath("//form[@id='data-form']//select[@id='yearOfPassing']"));
	          PassingYearSelect.click();
	          Select selYear=new Select(PassingYearSelect);
	          selYear.selectByValue("2014");
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          WebElement AssignedToSelect=driver.findElement(By.xpath("//select[@id='assignedTo']"));
	          AssignedToSelect.click();
	          Select selAssignedTo=new Select(AssignedToSelect);
	          selAssignedTo.selectByValue("17");
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          driver.findElement(By.xpath("(//button[normalize-space()='Submit'])[1]")).click();
	          WebElement SearchEnquiry=driver.findElement(By.xpath("//input[@id='searchfor']"));
	          SearchEnquiry.sendKeys("0000000002");
	          driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
	         WebElement result= driver.findElement(By.xpath("(//a[contains(text(),'0000000002')])[1]"));
	         System.out.println(result.getText());
	          
	          
	}
	
	
	
	
	
	
}
