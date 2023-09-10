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
public class TC29_ContactPage extends BaseTest {

	
ContactsPage cp;
	
	@Test
	void verifyCreateNewViewInTheContactPage() throws InterruptedException {
		
		loginToSalesForceApp();
		
		cp=new ContactsPage(getDriver());
		cp.clickOnContactsTab();
		
		String contactName1=cp.selectContact(getDriver());
		
		System.out.println(contactName1);
		
//		System.out.println(cp.verifySelectedCotactPageDisplayed(getDriver(),"L1AhW"));
		
		Assert.assertTrue(cp.verifySelectedCotactPageDisplayed(getDriver(), contactName1));
	}
}
