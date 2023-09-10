/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.CommonUtils;

import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC09_Logout extends BaseTest{
	
	UserMenuPage hp;
	
	@Test
	void logout() {
		loginToSalesForceApp();
		hp=new UserMenuPage(getDriver());
		
		hp.clickUserMenu();
		hp.clickLogOut();
		
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), "Login | Salesforce"));
	}
	
	

}
