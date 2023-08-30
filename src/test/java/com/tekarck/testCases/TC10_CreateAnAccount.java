/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC10_CreateAnAccount extends BaseTest {
	
	AccountsPage ap;
	
	@Test
	void createNewaccount() {
		
		loginToSalesForceApp();
		ap=new AccountsPage(driver);
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(driver));
		ap.clickNewBtn(driver);
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(driver));;
		ap.enterAccountName("QQQQQQQPP");
		ap.selectType("Technology Partner");
		ap.selectCustomerPriority("High");
		ap.clickSaveBtn(driver);
		Assert.assertTrue(ap.verifyAccountIsCreatd(driver,"QQQQQQQPP"));
		
		
	}

}
