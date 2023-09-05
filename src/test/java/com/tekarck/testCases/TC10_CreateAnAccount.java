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
		ap=new AccountsPage(getDriver());
		ap.clickAccountTab();
		Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
		ap.clickNewBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountEditPageDisplayed(getDriver()));;
		ap.enterAccountName("QQQQQQQPP");
		ap.selectType("Technology Partner");
		ap.selectCustomerPriority("High");
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyAccountIsCreatd(getDriver(),"QQQQQQQPP"));
		
		
	}

}
