/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.MyProfilePage;
import com.tekarck.pages.UserMenuPage;

/**
 * 
 */
public class TC34_VerifyUpdatedLastName extends BaseTest {
	
	
	MyProfilePage myProfilePage;
	UserMenuPage ump;
	
	
	
	@Test
	void VerifyUpdatedLastName() {
		
		ump=new UserMenuPage(getDriver());
		
		
		loginToSalesForceApp();
		
		ump.clickUserMenu();
		
		ump.clickMyProfile();
		
		myProfilePage=new MyProfilePage(getDriver());
		
		CommonUtils.waitForElementClickable(getDriver(), myProfilePage.getProfilePage());
		
		Assert.assertTrue(myProfilePage.isMyProfilePageIsVisible());
		
		Assert.assertTrue(myProfilePage.clickEditMyProfile(getDriver()));
		
		myProfilePage.switchFrame(getDriver());
		
		myProfilePage.clickAboutTab();
		
		String lastName=BaseTest.generateRandomString();
		
		myProfilePage.setLastName(lastName);
		
		myProfilePage.clickSaveAll(getDriver());
		
		Assert.assertTrue(myProfilePage.verifyEditedLastName(lastName));
		
		Assert.assertTrue(ump.verifyUserNameOnUserMenuBtn(lastName));
		
	}

}
