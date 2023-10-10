/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.AccountsPage;

/**
 * 
 */
public class TC11_CreateNewView extends BaseTest {
	
	AccountsPage ap;
	String viewName;
	
	@Test
	void createNewView() {
		loginToSalesForceApp();
		ap=new AccountsPage(getDriver());
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.HOME_PAGE_TITLE));
		ap.clickAccountTab();
	    Assert.assertTrue(ap.verifyAccountPageDisplayed(getDriver()));
	    ap.clickCreateNewView(getDriver());
	    Assert.assertTrue(ap.verifyCreateNewViewPageisDaisplayed(getDriver()));
	     viewName=BaseTest.generateRandomString();
	    String viewUniqueName=BaseTest.generateRandomString();
	    ap.enterViewName(viewName);
	    ap.enterViewUniqueName(viewUniqueName);
	    ap.clickSaveBtn(getDriver());
	    Assert.assertTrue(ap.verifyNewViewCreatedAndDisplyed(viewName));
	    
	   
	    
	}
	
	@AfterMethod
	void postConditions() {
		 /*
	     * Post conditions Delete view
	     */
		
	    Assert.assertTrue(ap.verifyDeleteViewCreated(viewName,getDriver()));
	}
	

}
