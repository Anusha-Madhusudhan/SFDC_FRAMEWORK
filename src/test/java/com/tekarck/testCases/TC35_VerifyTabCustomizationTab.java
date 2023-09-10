/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.HomePage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC35_VerifyTabCustomizationTab extends BaseTest {
	
	HomePage hp;
	UserMenuPage ump;
	
	
	@Test
	void VerifyTabCustomizationTab() {
		
		loginToSalesForceApp();
		
		hp=new HomePage(getDriver());
		ump=new UserMenuPage(getDriver());
		
		hp.clickOnPlusSign();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		hp.clickCustomizeTabBtn();
		String tabToBeRemoved="Chatter";
		
		Assert.assertTrue(hp.verifyCustomizeTabPageDisplayed(getDriver()));
		hp.selectTabFromSelectedTabList(tabToBeRemoved);
		hp.clickOnRemoveBtn();
		Assert.assertTrue(hp.verifyRemovedTabAvailableInAvailableTab(tabToBeRemoved));
		hp.clickSaveBtn();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		Assert.assertTrue(hp.vrifyRemovedTabPresentOnTheTabBar(tabToBeRemoved));
		ump.clickUserMenu();
		ump.clickLogOut();
		
		loginToSalesForceApp();
		
		Assert.assertTrue(hp.vrifyRemovedTabPresentOnTheTabBar(tabToBeRemoved));
		
		/*
		 * POST CONDITIONS code starts here
		 * 
		 * adding Tab - code should be here
		 */
		hp.clickOnPlusSign();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		hp.clickCustomizeTabBtn();
		String tabTobeAdded=tabToBeRemoved;
		hp.selectTabFromAvailableTabList(tabTobeAdded);
		hp.clickAddBtn();
		hp.clickSaveBtn();
		Assert.assertTrue(hp.verifyAllTabPageDisplayed(getDriver()));
		Assert.assertFalse(hp.vrifyRemovedTabPresentOnTheTabBar(tabTobeAdded));
		
		/*
		 * POST CONDITIONS code ends here
		 */
		
	}

}
