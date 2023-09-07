/**
 * 
 */
package com.tekarck.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
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
	String viewNameToBeEdited;
	String newViewName;
	

	
	@Test()
	void editView() {
		
		loginToSalesForceApp();
        Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.HOME_PAGE_TITLE));
        ap=new AccountsPage(getDriver());
		ap.clickAccountTab();
		
		/*
		 * 
		 * PreConditions For the test case Edit View Start here
		 * 
		 */
		

		List<WebElement> options=ap.getAllOptionsToEdit();
		
		viewNameToBeEdited=options.get(2).getText();
		
		newViewName=BaseTest.generateRandomString();
		/*
		 * 
		 * PreConditions For the test case Edit View Ends here
		 * 
		 */
		ap.selectViewNameToEdit(viewNameToBeEdited);// Need to change the view name before running the test.
		ap.clickEdit();
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(getDriver(), TitleConstants.EDIT_VIEW_PAGE_TITLE));
		
		Assert.assertTrue(ap.verifyViewNameToBeEditedOnEditPage(getDriver(),viewNameToBeEdited));
		
		ap.enterNewVieName(newViewName);
		ap.selectField("Account Name");
		ap.selectOperator("contains");
		ap.enterValue("a");
		
		Assert.assertTrue(ap.selectAvailabeFields("Last Activity"));
		ap.clickAddBtn();
		ap.clickSaveBtn(getDriver());
		Assert.assertTrue(ap.verifyTheEditedNewViewNameDisplayed(newViewName));
		Assert.assertTrue(ap.verifyTheColumnAddedToViewTable("Last Activity"));
//		Assert.assertTrue(ap.verifyAccountNameContainsLetterADispalyed("a"));
		
		
	}

}
