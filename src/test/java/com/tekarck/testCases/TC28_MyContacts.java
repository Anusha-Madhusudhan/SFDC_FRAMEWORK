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
public class TC28_MyContacts extends BaseTest {
	
    ContactsPage cp;
	
	@Test
	void verifyCreateNewViewInTheContactPage(){
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		cp.selectMyContacts("My Contacts");
		
		cp.clickGoBtn();
		
	    Assert.assertTrue(cp.verifyAllContactsDispalyed());
		
		
	}

}
