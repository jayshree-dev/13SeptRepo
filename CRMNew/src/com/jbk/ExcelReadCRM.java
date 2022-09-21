package com.jbk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadCRM {
	public static ArrayList<String> list;

	public static FileInputStream fis = null;
	public static File fi = null;
	public static Workbook wb = null;

	public static Sheet sh = null;
	public static String Filepath = "C:\\Users\\javabyKiran\\Desktop\\TestDataNew.xlsx";

	public static Object[][] readExcel(String filePath, int sheetnumber) throws IOException
			 {
		String[][] data = null;     
		
		        try
		
		        {

		        FileInputStream fis = new FileInputStream(filePath);
		
		        XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		        XSSFSheet sh = wb.getSheetAt(sheetnumber);
		
		        XSSFRow row = sh.getRow(0);
		
		        int noOfRows = sh.getPhysicalNumberOfRows();
		        
		
		        int noOfCols = row.getLastCellNum();
		
		        Cell cell;
		
		        data = new String[noOfRows][noOfCols];
		
		        for(int i =1; i<noOfRows;i++){
		
		             for(int j=0;j<noOfCols;j++){
		
		                   row = sh.getRow(i);
		
		                   cell= row.getCell(j);
		
		                   data[i][j] = cell.getStringCellValue();
		
		               }
		
		        }
		
		        }
		
		        catch (Exception e) {
		
		               System.out.println("The exception is: " +e.getMessage());
		
		                        }
		
		            return data;
		}
	
	
	public static Object[][] readExcelFirstRow(String filePath, int sheetnumber) throws IOException
	 {
String[][] datasend = null;     

       try

       {

       FileInputStream fis = new FileInputStream(filePath);

       XSSFWorkbook wb = new XSSFWorkbook(fis);

       XSSFSheet sh = wb.getSheetAt(sheetnumber);

       XSSFRow row = sh.getRow(0);

       int noOfRows = sh.getPhysicalNumberOfRows();

       int noOfCols = row.getLastCellNum();

       Cell cell;

       datasend = new String[noOfRows-3][noOfCols];
       
   		
           for(int j=0;j<noOfCols;j++){

                 row = sh.getRow(1);

                 cell= row.getCell(j);

                 datasend[1][j] = cell.getStringCellValue();

             }

      

      }

      catch (Exception e) {

             System.out.println("The exception is: " +e.getMessage());

                      }

          return datasend;
}
	
/*public static void main(String[] args) throws InvalidFormatException, IOException {
	ExcelReadCRM.readExcel((ExcelReadCRM.Filepath),0);*/
}	



	

