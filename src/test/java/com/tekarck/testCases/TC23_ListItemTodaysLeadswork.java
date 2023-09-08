/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.LeadsPage;

/**
 * 
 */
public class TC23_ListItemTodaysLeadswork extends BaseTest {
	LeadsPage lp;

	@Test
	void verifyListItemTodaysLeadswork() {
		
		loginToSalesForceApp();
		lp=new LeadsPage(getDriver());
		lp.clickLeadsTab();
	    Assert.assertTrue(lp.verifyLeadsPageDisplayed(getDriver()));
		
	    lp.selectTodaysLeads("Today's Leads");
	    lp.clickGoBtn();
	    Assert.assertTrue(lp.verifyTodaysLeadsPageDisplayed(getDriver(),"Today's Leads"));
	}
	
}
