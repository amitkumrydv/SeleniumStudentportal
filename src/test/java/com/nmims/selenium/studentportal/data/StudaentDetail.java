package com.nmims.selenium.studentportal.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nmims.selenium.studentportal.utilities.XLUtils;



public class StudaentDetail {

	public static Logger logger; 

	

	public List<String> studentDetailExcel(String path, String sheetName) throws IOException {
		List<String> expectedOptions = new ArrayList<String>();
		
		try {
		FileInputStream excelFilepath = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(excelFilepath);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = XLUtils.getRowCount(path, sheetName); // count row
//		int colcount = XLUtils.getCellCount(path, "Login_credentials", 1); // count column
//			
		
		for (int i = 1; i <= rowCount; i++) {
			
			Row row = sheet.getRow(i);
		
			 if (row != null) {
	            Cell cell = row.getCell(0); // Assuming options are in the first column (index 0)
	            if (cell != null) {
	            	
	            	 if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	            	        // Handle numeric value here
	            	        double numericValue = cell.getNumericCellValue();
	            	        String stringValue = String.valueOf(numericValue);
	            	        // Now you can work with stringValue as a string
	            	    } else {
	            	        // Handle other cell types (e.g., string, formula, etc.)
	            	        String stringValue = cell.getStringCellValue();
	            	        logger.info("Successfully read Excel data "+stringValue.toString() );
	            	        // Continue working with stringValue as a string
	            	    }
	              }
			 
			   }
	        }

	        workbook.close();
	        excelFilepath.close();
	      
	        
	    }catch (Exception e) {
			e.printStackTrace();
		}
		return expectedOptions;
		
	   }
	}
	

		

