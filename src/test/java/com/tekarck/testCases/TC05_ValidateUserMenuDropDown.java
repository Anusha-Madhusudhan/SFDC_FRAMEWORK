/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.ExcelUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.LoginPage;

/**
 * 
 */
public class TC05_ValidateUserMenuDropDown extends BaseTest {
	
	LoginPage lp;
	
	HomePage hp;
	/*
	 * Launch and Login 
	 * Check for user menu for <username> drop down
	 * Drop down with "My profile", "My Settings", "Developer Console","Logout" ,
	 * "Switching to lightning Experience" is displayed
	 */
	@Test
	void validateUserMenuDropDown() throws InvalidFormatException, IOException {
		
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
		
		String userName=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,1);
		String password=ExcelUtils.readCellDataFromExcelFile("UserCreds",1,2);
		
		lp.setUserName(userName);
		lp.setPassword(password);
		
		lp.clickLoginBtn();
		
		hp.clickUserMenu();
		
	    List<String> actualMenuItems=hp.getUserMenuItems();
	    
	    
	    
	    List<String> expectedMenuItems = new ArrayList<String>();

	    expectedMenuItems.add("My Profile");
	    expectedMenuItems.add("My Settings");
	    expectedMenuItems.add("Developer Console");
	    expectedMenuItems.add("Switch to Lightning Experience");
	    expectedMenuItems.add("Logout");
	    
	    
	    
	    int i = 0;
		boolean flag = false;
		for (String str : actualMenuItems) {

			if (str.equals(expectedMenuItems.get(i))) {
				i++;
				flag = true;
			} else {
				flag = false;
				break;
			}

		}

		

	Assert.assertTrue(flag);

		
	}

}
