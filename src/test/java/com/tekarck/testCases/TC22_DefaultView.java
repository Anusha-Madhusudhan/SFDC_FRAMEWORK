/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.HomePage;
import com.tekarck.pages.LeadsPage;

/**
 * 
 */
public class TC22_DefaultView extends BaseTest {
	LeadsPage lp;
	HomePage hp;

	@Test
	void verifyLeadsTab() {
		
		loginToSalesForceApp();
		lp=new LeadsPage(getDriver());
		hp=new HomePage(getDriver());
		lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyLeadsPageDisplayed(getDriver()));
	    lp.selectMyUnreadLeads("My Unread Leads");
	    hp.clickUserMenu();
	    hp.clickLogOut();
	    Assert.assertTrue(lp.verifyLoginPageDisplayed(getDriver()));
	    loginToSalesForceApp();
	    lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyDropDownListForDefoultSelectedOption("My Unread Leads"));
	   
	}
}
