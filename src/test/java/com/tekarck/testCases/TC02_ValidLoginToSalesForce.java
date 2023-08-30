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
public class TC02_ValidLoginToSalesForce extends BaseTest {
	
LoginPage lp;
	
	//Launch App
//	@Test
	void launchApp() {
		
		String expectedPagetitle="Login | Salesforce";
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedPagetitle));
		Assert.assertTrue(flag);
		
	}
	/*
	 * Enter User Name 
	   clear password
	   click on login btn
	   Validate homepage title
	 */
//	@Test
	void loginToSalesForceAppwithValidUserAndPwd() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		
//		lp.setUserName("anusha@tek.com");
//		lp.setPassword("Sumedh@03");
		
		
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,1);
		String password=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,2);
		
		lp.setUserName(userName);
		lp.setPassword(password);
		
		lp.clickLoginBtn();
		
		String expectedPageTitle="Home Page ~ Salesforce - Developer Edition";
		
		
		boolean flag=wait.until(ExpectedConditions.titleIs(expectedPageTitle));
		Assert.assertTrue(flag);
		
	}
	
	
	/*
	 * Enter User Name 
	   clear password
	   click on login btn
	   Validate homepage title
	 */
	@Test
	void loginToSalesForceAppForMultipleUsers() throws InvalidFormatException, IOException {
		lp=new LoginPage(driver);
		
//		lp.setUserName("anusha@tek.com");
//		lp.setPassword("Sumedh@03");
		
		
		String[][] userCreds=ExcelUtils.readExcelFile("UserCreds");
		
		for(String[] row:userCreds) {
			
			for(int i=0;i<row.length;i++) {
				lp.setUserName(row[i]);
				lp.setPassword(row[++i]);
			}
			lp.clickLoginBtn();
			
			
			String expectedPageTitle="Home Page ~ Salesforce - Developer Edition";
			
			
			boolean flag=wait.until(ExpectedConditions.titleIs(expectedPageTitle));
			Assert.assertTrue(flag);
			

//			lp.clickLogoutBtn();
		
			
			break;
		}

		
//		lp.setUserName(userName);
//		lp.setPassword(password);
		
//		lp.clickLoginBtn();
		
		
		
	}

}
