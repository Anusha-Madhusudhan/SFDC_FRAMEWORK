/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
public class TC01_LoginErrorMessage extends BaseTest {
	
	LoginPage lp;
	
	//Launch App
	@Test
	void launchApp() {
		
		String expectedPagetitle="Login | Salesforce";
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedPagetitle));
		Assert.assertTrue(flag);
		
	}
	
	//Enter User Name 
	//clear password
	// click on login btn
	// Validate error msg
	@Test
	void enterUserName() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		
		
		String userNme=ExcelUtils.readCellDataFromExcelFile("UserCreds", 2, 1);
//		String password=ExcelUtils.readExcelFile("UserCreds", 2, 2);
		
		lp.setUserName(userNme);
		lp.setPassword("");
		lp.clickLoginBtn();
		
		String expectedErrorMsg="Please enter your password.";
		
		String actualErrorMsg=lp.getErrorMsg();
		
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		
		
		
	}
	
	
	
	

}
