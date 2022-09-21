package com.jbk;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write {
	
	 public String ColName="Result";
	 public int col_num;
	 public static String Filepath = "C:\\Users\\javabyKiran\\Desktop\\AddEnqData.xlsx";
	 public Workbook workbook;
	 public Sheet worksheet;
	 public void WriteResult(String Ress, int sheetnumber) throws Exception
	 {
	 FileInputStream file_input_stream= new FileInputStream(Filepath);
	 
	 workbook=WorkbookFactory.create(file_input_stream);
	 worksheet=workbook.getSheetAt(sheetnumber);
	 Row Row=worksheet.getRow(0);
	 Cell cell   =worksheet.getRow(0).getCell(col_num);
	 if(cell==null) {
		 cell=Row.createCell(col_num);
		 
		 }
	cell.setCellValue(Ress);
	FileOutputStream file_output_stream=new FileOutputStream(Filepath);
	workbook.write(file_output_stream);
	
	}
	 
}
