/**
 * 
 */
package com.tekarck.testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarck.pages.HomePage;

/**
 * 
 */
public class TC36_BlockingAnEventInTheCalender extends BaseTest {
	HomePage hp;
	@Test
	void verifyBlockingAnEventInTheCalender() {
		
		loginToSalesForceApp();
		hp=new HomePage(getDriver());
		
		hp.clickHomTab();
		
        String expecteddate=new SimpleDateFormat("EEEE MMMM dd, yyyy").format(new Date());
		
	    Assert.assertTrue(hp.vrifyCurrentDateDisplayed(expecteddate));
	    
	    hp.clickOnCurrentDateLink();
	    
	    String userName="Anusha XXXX";
	    
	    Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
	    
	    hp.clickOn8PMLink();
	    
	    Assert.assertTrue(hp.verifyCandelNewEventPageIsDisplayed(getDriver()));
	    hp.clickOnSubjectComboLinkAndSelectOtherFromComboBox(getDriver());
	    hp.clickOnEndTime();
	    hp.select9PMFromTheDropDown();
	    
	    hp.clickSaveBtn();
	    
	    Assert.assertTrue(hp.verifyCalenderPageDisplaedForFirstNameAndLastName(userName));
	    
	    Assert.assertTrue(hp.verifyOtherEventDispalyedBetweenTimeSlot8PMTo9PM(getDriver()));
	    
	    /*
		 * POST Conditions Deleting the event created
		 * 
		 */
	    
		
		
		Assert.assertTrue(hp.deleteEvent(getDriver()));
		
		
		/*
		 * POST Conditions Deleting the event created
		 * 
		 */
		
	    
	}

}
