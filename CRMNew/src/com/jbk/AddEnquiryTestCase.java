package com.jbk;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddEnquiryTestCase {
   WebDriver driver;
   private String sTestCaseName;
   
   private int iTestCaseRow;

   @Test(priority=1)
public void GoToAddEnqPage() {
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
}

@Test(priority=2,dataProvider = "AddEnqData")
public void SendDataToAddEnqPage(String Name,String Surname,String Email,int PhoneNo,int WhatsNo) {
	driver.findElement(By.xpath("(//input[@id='firstName'])[1]")).sendKeys(Name);
	
	}

@DataProvider(name="AddEnqData")
public Object[][] ReadVariant() throws InvalidFormatException, IOException 
{
	 
	
	 Object[][] arrObj = ExcelReadCRM.readExcel((ExcelReadCRM.Filepath),0);
	 return arrObj;
	}
	
}
	      
	


