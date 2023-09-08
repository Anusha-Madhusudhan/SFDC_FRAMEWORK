/**
 * 
 */
package com.tekarck.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.ContactsPage;

/**
 * 
 */
public class TC25_CreateNewContact extends BaseTest {
	
	ContactsPage cp;
	
	@Test
	void verifyCreateNewContact(){
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		cp.clickNewBtn();
	    Assert.assertTrue(cp.verifyContactEditPageIsDispalyed(getDriver()));
	    String lastName=BaseTest.generateRandomString();
		cp.enterLastName(lastName);
		cp.clickAccountSearchImg(getDriver());
		cp.clickSaveBtn();
		Assert.assertTrue(cp.verifyNewCantactCreated(getDriver(),lastName));
		
	}
	

}
