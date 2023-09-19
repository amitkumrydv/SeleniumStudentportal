package com.nmims.selenium.studentportal.data;

import org.testng.annotations.DataProvider;

import com.nmims.selenium.studentportal.utilities.XLUtils;

public class DataProvideLogin {
	
	@DataProvider(name = "Login") // Excel file name
	static String[][] getData() {

		try {
			String path = System.getProperty("user.dir") + "/TestDataFile/Login.xlsx";

			int rownum = XLUtils.getRowCount(path, "Login_credentials"); // count row
			int colcount = XLUtils.getCellCount(path, "Login_credentials", 1); // count column

			String logindata[][] = new String[rownum][colcount];

			for (int i = 1; i <= rownum; i++) {

				for (int j = 0; j < colcount; j++) {

					logindata[i - 1][j] = XLUtils.getCellData(path, "Login_credentials", i, j); // 1,0
				}
			}

			return logindata;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getData();
	}

}
