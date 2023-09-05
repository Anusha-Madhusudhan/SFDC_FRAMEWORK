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
public class TC03_CheckRememberMe extends BaseTest {
	
	LoginPage lp;
	
	// Login to SFDC with remember username check box checked
	//Log out of SFDC
	//Check for Username field
	@Test
	void loginAndCheckRememberMe() throws InvalidFormatException, IOException {
		
		lp=new LoginPage(getDriver());
		
		lp.setUserName(ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 1));
		
		lp.setPassword(ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 2));
		
		lp.clickRememberMe();
		
		lp.clickLoginBtn();
		
		String expectedPageTitle=TitleConstants.HOME_PAGE_TITLE;
		
		
		boolean flag=CommonUtils.waitForTitleOfThePage(getDriver(), expectedPageTitle);
		Assert.assertTrue(flag);
		
		lp.clickLogoutBtn();
		
      
       String expecteSavedUserName=ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 1);
       String actualSavedUserName=lp.getSavedUserName(driver,expecteSavedUserName);
		
		Assert.assertEquals(actualSavedUserName,expecteSavedUserName);
		
	}
	
	
	
	
	
	
	
	
	
	

}
