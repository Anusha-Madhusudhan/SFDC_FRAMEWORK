/**
 * 
 */
package com.tekarch.utils;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

/**
 * 
 */
public class DataProviderClass {
	
	@DataProvider(name = "LoginDataProvider")
	public Object[][] getData() {
		Object[][] loginData = null;
		try {
			loginData=ExcelUtils.readExcelFile("UserCreds");
		} catch (InvalidFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return loginData;
	}

}
