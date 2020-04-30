package com.comparethemarket.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadDataFromExcel {
	
	
	public static String clientName;
	public static String clientCode;
	public static String clientSite;
	public static String clientCarrier;
	public static String clicentService;
	public static String clicentMethod;
	public static String clicentAddressLine1;
	public static String clicentAddressLine2;
	public static String clicentAddressLine3;
	public static String clicentPostcode;
	
	
	
	public String[][] getUserDataFromFile(String sheetName, int rowNumber) throws IOException {
		// Get the file location

		//File excel = new File("C:\\Users\\estrelcenia\\eclipse-workspace\\SeleniumTestiForce\\DataSheets\\testDataQA.xlsx"); 
		//String path= System.getProperty("user.dir")+"\\DataSheets\\testDataQA.xlsx";	
		//System.out.println("Path:"+ path);
		File excel = new File("C:\\Users\\estrelcenia\\eclipse-workspace\\SeleniumTestiForce\\DataSheets\\testDataQA.xlsx"); 
				
		FileInputStream fis = new FileInputStream(excel);

		// Declare an array to store the values
		String[][] dataArray = null;
		// Loading workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheet(sheetName);

		
		Row row = sheet.getRow(rowNumber - 1);
		// Get the total no of column and rows
		int totalNoOfCols = row.getLastCellNum() - row.getFirstCellNum();
		int totalNoOfRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("col: " + totalNoOfCols);
		System.out.println("rows: " + totalNoOfRows);
		// Setting the array length according to no of rows and columns to read
		dataArray = new String[1][totalNoOfCols];
		int ci = 0;
		for (int i = 1; i <= 1; i++) {
			// Start the loop to read the particular rows
			int cj = 0;
			for (int j = 0; j < totalNoOfCols; j++, cj++) {
				Cell cell = row.getCell(cj);
				//cell.setCellType(Cell.CELL_TYPE_STRING);
				dataArray[ci][cj] = cell.getStringCellValue();
				//System.out.println(ci + " " + cj + " " + dataArray[ci][cj]);
			}
			ci++;

		}
		wb.close();
		setIssuerDatafromArray(dataArray);
		return dataArray;
	}
	
	
	
	public void setIssuerDatafromArray(String[][] dataArray) throws IOException {
		int arrayNumber = 0;

		clientName = dataArray[arrayNumber][0];
		clientCode = dataArray[arrayNumber][1];
		clientSite = dataArray[arrayNumber][2];
		clientCarrier = dataArray[arrayNumber][3];
		clicentService = dataArray[arrayNumber][4];
		clicentMethod = dataArray[arrayNumber][5];
		clicentAddressLine1 = dataArray[arrayNumber][6];
		clicentAddressLine2 = dataArray[arrayNumber][7];
		clicentAddressLine3 = dataArray[arrayNumber][8];
		clicentPostcode = dataArray[arrayNumber][9];
	}
	
	
	

}
