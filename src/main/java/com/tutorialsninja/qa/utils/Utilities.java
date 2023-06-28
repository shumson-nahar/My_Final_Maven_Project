package com.tutorialsninja.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class Utilities {
	public static final int IMPLICIT_WAIT_TIME =10;
	public static final int PAGE_load_TIME =5;
	//public static final long PAGE_lOAD_TIMEOUT = 0;
	public static final long SCRIPT_TIMEOUT = 0;
	/*
	 * public static final int IMPLICIT_WAIT_TIME = 100; public static final int
	 * PAGE_lOAD_TIMEOUT = 100; public static final int SCRIPT_TIMEOUT = 1000;
	 * 
	 */
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":","_");
		return"naharshumson"+timestamp+"@gmail.com";
		
	}
	@DataProvider(name ="validCredentialsSupplier")
	public Object supplyTestData() throws IOException {
		Object[][] data = Utilities.readDataTNFromExcel("Login");
	return data;
	
	}
	
	public static Object[][] readDataTNFromExcel(String sheetName) throws IOException {
		//Create the Object of FileInputStream and pass the path of Excel in the constructor 
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\com\\qa\\tutorialsNinja\\testdata\\TutorialNinjaExcelSheet.xlsx");
	   //Create the Object of XSSFWorkbook
		
		XSSFWorkbook workbook = new XSSFWorkbook(ip);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//no of rows and cols 
		int rows = sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		for(int i =0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0;j<cols;j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
				case STRING:
					data[i][j]= cell.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j]=Integer.toString((int)cell.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j]= cell.getBooleanCellValue();
					break;
							
					
				
				}
			}
		}
		return data;
	}

}
