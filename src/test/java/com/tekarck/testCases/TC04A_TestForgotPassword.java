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
public class TC04A_TestForgotPassword extends BaseTest {
	LoginPage lp;
	
	//Open <https://login.salesforce.com/> page in browser
	//Click on Forgot password
	//Provide <username> in salesforce forgot password page and click on contiue button
	
	@Test
	void forgotPwd() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		
		lp.clickForgotPassword();
		lp.setForgotPwdUserName(ExcelUtils.readCellDataFromExcelFile("UserCreds",1, 1));
		
		lp.clickContinueBtn();
		
		String expectedTitle="Check Your Email | Salesforce";
		
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedTitle));
		
		Assert.assertTrue(flag);
	}

}
