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
public class TC12_EditView extends BaseTest {
	
	AccountsPage ap;
	
	@Test
	void editView() {
		
		
		
		loginToSalesForceApp();
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.HOME_PAGE_TITLE));
		
		ap=new AccountsPage(getDriver());
		
		ap.clickAccountTab();
		ap.selectViewNameToEdit("LMN");// Need to change the view name before running the test.
		ap.clickEdit();
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.EDIT_VIEW_PAGE_TITLE));
		
		Assert.assertTrue(ap.verifyViewNameToBeEditedOnEditPage(getDriver(),"LMN"));
		
		ap.enterNewVieName("ABCD_PPPPP");
		ap.selectField("Account Name");
		ap.selectOperator("contains");
		ap.enterValue("a");
		
		ap.selectAvailabeFields("Last Activity");
		ap.clickAddBtn();
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyTheEditedNewViewNameDisplayed("ABCD_PPPPP"));
		Assert.assertTrue(ap.verifyTheColumnAddedToViewTable("Last Activity"));
	}

}
