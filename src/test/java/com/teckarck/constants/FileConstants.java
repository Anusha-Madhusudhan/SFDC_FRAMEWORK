/**
 * 
 */
package com.teckarck.constants;

import com.tekarch.utils.CommonUtils;
import com.tekarck.testCases.BaseTest;

/**
 * 
 */
public class FileConstants {
	
	public static  final String TEST_DATA_PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testData.properties";
	public static  final String LOGIN_TEST_DATA_PROPERTIES_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.properties";
	public static  final String TEST_REPORT_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\"+ CommonUtils.getTimeStamp()+"TestReport.html";
	public static  final String SCREENSHOT_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+ CommonUtils.getTimeStamp()+"screenShot.png";
	public static  final String LOGIN_TEST_DATA_EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.xlsx";
	
}
