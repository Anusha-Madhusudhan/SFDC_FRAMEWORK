/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.teckarck.constants.TitleConstants;
import com.tekarch.listeners.SFDC_Listener;
import com.tekarch.utils.CommonUtils;
import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
//@Listeners(SFDC_Listener.class)
public class TC02_ValidLoginToSalesForce extends BaseTest {

	LoginPage lp;
	HomePage hp;

	// Launch App
	@Test
	void launchApp(Method mName) {
		
		logger.info("INIDE THe CLASS :    "+this.getClass().getName());
		
		logger.info("Inside the method:    "+mName.getName());
	
		logger.info("launching the application");

		String expectedPagetitle = TitleConstants.LOGIN_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
		Assert.assertTrue(flag);
		
		logger.info("Login Page title :"+expectedPagetitle);

	}

	/*
	 * Enter User Name clear password click on login btn Validate homepage title
	 */
//	@Test
	void loginToSalesForceAppwithValidUserAndPwd(Method mName) throws InvalidFormatException, IOException {
		
		logger.info("Test case satrted here :    "+mName.getName());
		lp = new LoginPage(driver);

//		lp.setUserName("anusha@tek.com");
//		lp.setPassword("Sumedh@03");

		String userName = ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 1);
		String password = ExcelUtils.readCellDataFromExcelFile("UserCreds", 1, 2);

		lp.setUserName(userName);
		logger.info("Entered Username :"+userName);
		lp.setPassword(password);
		logger.info("Entered  password :"+password);

		lp.clickLoginBtn();
		logger.info("Clicked on login button");

		String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;

		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPageTitle);
		Assert.assertTrue(flag);
		
		logger.info("After successfull login Home page title should be :"+expectedPageTitle);

	}

	/*
	 * Enter User Name clear password click on login btn Validate homepage title
	 */
//	@Test
	void loginToSalesForceAppForMultipleUsers(Method mName) throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		logger.info("Test case satrted here :    "+mName.getName());
		logger.info("Validating Login for multiple users");
		SoftAssert softAssert = new SoftAssert();
		
		String userName=null;
		String password=null;

		String[][] userCreds = ExcelUtils.readExcelFile("UserCreds");

		for (String[] row : userCreds) {

			for (int i = 0; i < row.length; i++) {
				 userName=row[i];
				 password=row[++i];
				
				lp.setUserName(userName);
				logger.info("Entered Username :"+userName);
				lp.setPassword(password);
				logger.info("Entered  password :"+password);
			}
			lp.clickLoginBtn();
			logger.info("Clicked on login button");

			String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;
			boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedPageTitle);
			
			if (flag) {
				softAssert.assertTrue(flag);
				logger.info("Successfull login to the appln SFDC for User Name and password :"+userName+"   "+password);
				hp.clickUserMenu();
				hp.clickLogOut();
			}
			else {
				softAssert.assertTrue(flag,"Failed to login for User Name and password :"+userName+"  "+password);
				
				logger.info("Failed to login for User Name and password :"+userName+"   "+password);
				logger.info("Error MSg :"+lp.getErrorMsg());
			}
		}
		softAssert.assertAll();
	}
	
	
	/*
	 * Enter User Name clear password click on login btn Validate homepage title
	 */
	@Test(dataProvider = "LoginDataProvider" , dataProviderClass = com.tekarch.utils.DataProviderClass.class)
	void loginToSalesForceAppUsingDataProviders(Method mName, String userName,String password) throws InvalidFormatException, IOException {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		logger.info("Test case satrted here :    "+mName.getName());
		logger.info("Validating Login for multiple users");
		
		lp.setUserName(userName);
		logger.info("Entered Username :"+userName);
		lp.setPassword(password);
		logger.info("Entered  password :"+password);
				
		
		lp.clickLoginBtn();
		logger.info("Clicked on login button");

		String expectedPageTitle = TitleConstants.HOME_PAGE_TITLE;
		boolean flag=CommonUtils.waitForTitleOfThePage(driver, expectedPageTitle);

		if (flag) {
				
		Assert.assertTrue(flag);
		logger.info("Successfull login to the appln SFDC for User Name and password :"+userName+"   "+password);
		hp.clickUserMenu();
		hp.clickLogOut();
}
		else {
			logger.info("Failed to login for User Name and password :"+userName+"   "+password);
			logger.info("Error MSg :"+lp.getErrorMsg());
		    Assert.assertTrue(flag,"Failed to login for User Name and password :"+userName+"  "+password);
			}
	}

}
