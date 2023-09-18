package com.nmims.selenium.studentportal.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nmims.selenium.studentportal.utilities.XLUtils;

public class StudaentDetail {

	public static Logger logger;

	public List<String> studentDetailExcel(String path, String sheetName) throws IOException {
		List<String> expectedOptionslist = new ArrayList<String>();
		DataFormatter dataFormatter = new DataFormatter();

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

							String cellValue = dataFormatter.formatCellValue(cell);
							expectedOptionslist.add(cellValue);


						} else {

							String stringValue = cell.toString();
							expectedOptionslist.add(stringValue);

						}
					}

				}
			}

			workbook.close();
			excelFilepath.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return expectedOptionslist;

	}
}
