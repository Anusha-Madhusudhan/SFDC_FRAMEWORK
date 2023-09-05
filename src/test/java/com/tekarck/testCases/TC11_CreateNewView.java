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
		ap=new AccountsPage(getDriver());
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.HOME_PAGE_TITLE));
		ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
	    ap.clickCreateNewView(getDriver());
	    Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(getDriver()));
	    ap.enterViewName("ABCDEF");
	    ap.enterViewUniqueName("ABCDEFQA");
	    ap.clickSaveBtn(getDriver());
	    Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed("ABCDEF"));
	    
	    
		
	}
	

}
