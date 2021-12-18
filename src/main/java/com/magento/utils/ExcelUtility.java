package com.magento.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static Workbook book;
	static Sheet sheet;
	public static void openExcel(String filepath) {
		
		try {
			FileInputStream fis= new FileInputStream(filepath);
		   book= new XSSFWorkbook(fis); //will read xlsx format
		 //   Workbook book1= new HSSFWorkbook(fis);//will read xls format 
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetname) {
		 sheet= book.getSheet(sheetname);
	}
	
	public static int rowsCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	public static int columnsCount(int index) {
		return sheet.getRow(index).getLastCellNum();
	}
	
	public static String getCellData(int rowindex,int columnindex) {
		return sheet.getRow(rowindex).getCell(columnindex).toString();
	}
	
	//return 2d object array of data 
	
	public static Object[][] excelIntoArray(String filePath,String sheetName){
		
	      openExcel(filePath);
	      loadSheet(sheetName);
	      
	     int totalRows=rowsCount();
	     int totalColumns=columnsCount(0);
	     
	     Object[][] data = new Object[totalRows-1][totalColumns];
	     
	     for(int i=1;i<totalRows;i++) {
	    for(int j=0;j<totalColumns;j++) {
	    		 
	    	data[i-1][j]= 	getCellData(i,j);
	    	 }
	     }
	     return data;
	
	}
}
