/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
public class TC04B_InvalidUserNameAndPassword extends BaseTest {
	
	LoginPage lp;
	
	//Launch the application
	//Enter Wrong USerName
	//Enter wrong PWd
	//Click Login
	//Validate error message
	
	@Test
	void loginToAppWithInvalidCreds() throws InvalidFormatException, IOException {
		lp=new LoginPage(getDriver());
		
		lp.setUserName(ExcelUtils.readCellDataFromExcelFile("UserCreds",4, 1));
		
		lp.setPassword(ExcelUtils.readCellDataFromExcelFile("UserCreds",4, 2));
		
		lp.clickLoginBtn();
		
		String expectedErr="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		String actualError=lp.getErrorMsg();
		
		Assert.assertEquals(actualError, expectedErr);
	}
	

}
