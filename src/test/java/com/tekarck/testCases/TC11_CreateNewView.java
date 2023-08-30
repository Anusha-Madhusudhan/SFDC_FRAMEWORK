/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC11_CreateNewView extends BaseTest {
	
	AccountsPage ap;
	
	@Test
	void createNewView() {
		loginToSalesForceApp();
		ap=new AccountsPage(driver);
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.HOME_PAGE_TITLE));
		ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(driver));
	    ap.clickCreateNewView(driver);
	    Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(driver));
	    ap.enterViewName("ABCDEF");
	    ap.enterViewUniqueName("ABCDEFQA");
	    ap.clickSaveBtn(driver);
	    Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed("ABCDEF"));
	    
	    
		
	}
	

}
