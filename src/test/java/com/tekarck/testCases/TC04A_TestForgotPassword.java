/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
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
		lp=new LoginPage(getDriver());
		
		lp.clickForgotPassword();
		lp.setForgotPwdUserName(ExcelUtils.readCellDataFromExcelFile("UserCreds",1, 1));
		
		lp.clickContinueBtn();
		
		String expectedTitle=TitleConstants.FORGOT_PASSWORD_PAGE_TITLE;
		
		boolean flag=CommonUtils.waitForTitleOfThePage(getDriver(), expectedTitle);
		
		Assert.assertTrue(flag);
	}

}
