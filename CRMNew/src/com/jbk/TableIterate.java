package com.jbk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

public class TableIterate {
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
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  WebElement Table=driver.findElement(By.xpath("//table[@id='data_table_all']"));
			  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  JavascriptExecutor executor1 = (JavascriptExecutor) driver;
              executor1.executeScript("scrollBy(0,200)");
              driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			  List<WebElement> tableRow =Table.findElements(By.xpath("table[@id=’data_table_all’]/thead/tbody/tr/td"));
			  
				List< WebElement > td = Table.findElements(By.tagName("td")); 
				System.out.println(tableRow.size()); 
				 /* int tdcount=td.size(); 
				 * Iterator<WebElement> itr=tr.iterator();
				 * Iterator<WebElement> itd=td.iterator(); while(itr.hasNext()) { WebElement
				 * row= itr.next();
				 * 
				 * while(itd.hasNext()) { WebElement col= itd.next();
				 * System.out.println(col.getText()); {
				 * 
				 * }
				 * 
				 * }
				 * 
				 * }
				 */
				 
					/*
					 * String Rows=row.getText(); System.out.println(Rows);
					 */
				
			  
			  for(int row=1;row<tableRow.size();row++) {
				  
				  
				  WebElement colData= tableRow.get(row);
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				  List<WebElement> tableCol = Table.findElements(By.tagName("td"));
				  for(int col=0;col<tableCol.size();col++) {
					 String result=tableCol.get(col).getText();
					  if(result.equalsIgnoreCase("TestAuto TestAuto")){
						 
		                    
						
						  String xp1 ="//body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[";
						 String xp2 = "]/td[2]"; 
						 String Final =xp1+row+xp2;
						 
		                   String newRes=driver.findElement(By.xpath("//div[2]/table[1]/tbody[1]/tr["+row+"]/td[2]")).getText();
		                    System.out.println(newRes);
		                    JavascriptExecutor executor = (JavascriptExecutor) driver;
		                    executor.executeScript("scrollBy(0,200)");
		                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		                    
		                }
		                
		                 System.out.println(result);
		            }}
}
} 
				  
				  
				  
			  
			  
			  
			  
			  
			 


