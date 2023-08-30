/**
 * 
 */
package com.tekarch.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.teckarck.constants.WaitCostants;

/**
 * 
 */
public class CommonUtils {
	
	
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}
	
	
	public static boolean waitForNumOfWindowsToBe(WebDriver driver, int iNumberOfWindows) {
		boolean isAllWindowsOpened = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			isAllWindowsOpened =wait.until(ExpectedConditions.numberOfWindowsToBe(iNumberOfWindows));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAllWindowsOpened;
	}
	
	
	
	public static boolean waitForText(WebDriver driver, WebElement element,String text) {
		boolean isTextPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
			isTextPresent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTextPresent;
	}
	
	
	public static boolean waitForTitleOfThePage(WebDriver driver,String title) {
		boolean isTitlePresent = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			isTitlePresent =wait.until(ExpectedConditions.titleIs(title));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTitlePresent;
	}
	
	public static boolean waitForElementToVisible(WebDriver driver, WebElement element) {
		boolean isElementVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementVisible = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementVisible;
	}
	
	
	
	
	public static WebDriver waitForFrameToBeAvailableToSwitch(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT);
		try {
			driver=wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	
	
	public static boolean waitForElementToDisapear(WebDriver driver, WebElement element) {
		boolean isElementDisapear = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT_TO_DISAPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementDisapear = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementDisapear;
	}

	public static boolean waitForTitleContais(WebDriver driver, String sText) {
		boolean isTitleContainsText = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitCostants.WAIT_FOR_ELEMENT_TO_DISAPEAR);
		try {
			isTitleContainsText =wait.until(ExpectedConditions.titleContains(sText));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTitleContainsText;
	}
}

