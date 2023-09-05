/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.listeners.SFDC_Listener;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
//@Listeners(SFDC_Listener.class)
public class TC01_LoginErrorMessage extends BaseTest {
	
	LoginPage lp;
	
	//Launch App
	@Test
	void launchApp(Method name) throws IOException {
		logger.info("Inside the Class "+this.getClass().getName());
		logger.info("Inside the method "+name.getName());
//		test.info("Launching the application");
		String expectedPagetitle=TitleConstants.LOGIN_PAGE_TITLE;
		boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
		Assert.assertTrue(flag);
		logger.info("application launched with title :"+ expectedPagetitle);
//		test.pass("application launched with title :"+ expectedPagetitle);
//		test.addScreenCaptureFromPath(getScreenShot(driver));
		
	}
	
	//Enter User Name 
	//clear password
	// click on login btn
	// Validate error msg
	@Test
	void validateLoginToTheApplnWithBlankPassword(Method name) throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		logger.info("Inside the method "+name.getName());
		
		String userNme=ExcelUtils.readCellDataFromExcelFile("UserCreds", 2, 1);
//		String password=ExcelUtils.readExcelFile("UserCreds", 2, 2);
		
		lp.setUserName(userNme);
		logger.info("Entered Username :"+userNme);
//		test.info("Entered username");
		lp.setPassword("");
		logger.info("Entered blank password :"+" ");
//		test.info("password is blank");
		lp.clickLoginBtn();
		logger.info("Clicked on login button");
//		test.info("click on login button");
		
		String expectedErrorMsg="Please enter your password.";
		
		
		
		boolean flag=lp.isErrorMsgDisaplyed(driver,expectedErrorMsg);
		
//		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		Assert.assertTrue(flag);
		
		logger.info("Got the error message  :"+expectedErrorMsg);
		logger.info("Login sholud not happen with blank password");
		
//		test.info("got the error msg :"+actualErrorMsg);
//		test.pass("Login sholud not happen with blank password");
//		test.addScreenCaptureFromPath(getScreenShot(driver));
		
	}
	
	
	
	

}
