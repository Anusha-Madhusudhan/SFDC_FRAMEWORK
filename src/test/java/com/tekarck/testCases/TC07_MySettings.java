/**
 * 
 */
package com.tekarck.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.MySettingPage;

/**
 * 
 */
public class TC07_MySettings extends BaseTest {

	HomePage hp;
	MySettingPage mySettingPage;
	
	@Test
	void mySetting() {
		hp=new HomePage(driver);
		
		loginToSalesForceApp();
		
		hp.clickUserMenu();
		hp.clickMySettings();
		
		String expectedText="My Settings";
		
		String actualText=driver.findElement(By.xpath("//span[@class='folderText']")).getText();
		
		Assert.assertEquals(actualText, expectedText);
		
	}
	@Test(dependsOnMethods ="mySetting" )
	void personalLink() {
		mySettingPage=new MySettingPage(driver);
		mySettingPage.clickPersonalLink();
		mySettingPage.clickLoginHistory();
		Assert.assertTrue(mySettingPage.clickDownloadLogin());
		
		
		
	}
	
	
	/*
	 * Click on Display & Layout link and select Customize My Tabs link. 
	 * Select "Salesforce Chatter" option from custom App: drop down. 
	 * Select Reports tab from Available Tabs list. Click on >(Add) button. 
	 */
	
	@Test(dependsOnMethods ="mySetting" )
	void displayAndLayout() {
		mySettingPage=new MySettingPage(driver);
		mySettingPage.clickDispalyAndLayoutLink();
		mySettingPage.clickCustomizeTabs();
		mySettingPage.selectSalesForceChatter("Salesforce Chatter");
		if(!mySettingPage.selectReportTab("Reports")) {
			
			mySettingPage.clickAddBtn();
		}
		
		mySettingPage.clickSaveBtn();
		Assert.assertTrue(mySettingPage.verifyReportsAddedToTabMenu("Reports"));
		
		
		
	}
	
	/*
	 * Click on Email link and click on my email settings link under that
	 * Provide <EmailName> in Email Name field,
	 *  <EmailAddress> in Email Address field, 
	 *  Select automatic BCC radio button and click on save button
	 */
	
	@Test(dependsOnMethods ="mySetting" )
	void email() {
		mySettingPage=new MySettingPage(driver);
		
		mySettingPage.clickEmail();
		mySettingPage.clickEmailSettings();
		mySettingPage.setEmailName("ABCDEF");
		mySettingPage.setEmailAddress("anusha.basavaraj28@gmail.com");
		mySettingPage.selectAutomaticBCC();
		mySettingPage.clickSaveBtn();
		
		
		
		Assert.assertTrue(mySettingPage.verifyEmailUpdation(driver));
		
		String expectedTitle="My Email Settings ~ Salesforce - Developer Edition";
		
		Assert.assertTrue(CommonUtils.waitForTitleOfThePage(driver, expectedTitle));
		
	}
	
	/*
	 * Click on Calendar & Remainders link and click on Activity Remainders link. 
	 * On Remainders page click on Open a test Remainder button.
	 * Sample event pop window is dispayed.
	 */
	
	@Test(dependsOnMethods ="mySetting" )
	void calenderAndReminders() throws InterruptedException {
		mySettingPage=new MySettingPage(driver);
		mySettingPage.clickCalenderAndRamainder();
		mySettingPage.clickActivityRemainder();
        mySettingPage.clickOpenTestRemainder(driver);
		Assert.assertTrue(mySettingPage.verifyThePopUpWindow(driver));
	}
}
