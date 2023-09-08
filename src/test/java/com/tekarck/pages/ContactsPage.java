/**
 * 
 */
package com.tekarck.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;

/**
 * 
 */
public class ContactsPage extends BasePage {
	
	public ContactsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Contact_Tab")
	private WebElement contacts;
	
	@FindBy(xpath = "//input[@value=' New ']")
	private WebElement newBtn;
	
	@FindBy(id = "name_lastcon2")
	private WebElement lastName;
	
	@FindBy(id = "con4_lkwgt")
	private WebElement accountName;
	
	@FindBy(id = "lksrch")
	private WebElement inputText;
	
	private String iFrameSearch="searchFrame";
	
	private String iFrameResult="resultsFrame";
	
	@FindBy(xpath = "//input[@value=' Go! ']")
	private WebElement goBtn;
	
	@FindBy(xpath = "//table//tbody//tr//th//a")
	private List<WebElement> accountList;
	
	
	@FindBy(xpath = "//input[@value=' Save ']")
	private WebElement saveBtn;
	
	
	@FindBy(xpath = "//div[@class='textBlock']//h2")
	private WebElement lastNameText;
	
	@FindBy(linkText = "Create New View")
	private WebElement newViewBtn;
	
	@FindBy(id = "fname")
	private WebElement viewName;

	@FindBy(id = "devname")
	private WebElement viewUniqueName;
	
	@FindBy(xpath = "//select[@class='title']")
	private WebElement view;
	
	@FindBy(id = "hotlist_mode")
	private WebElement recentCont;
	
	@FindBy(xpath = "//table[@class='list']//tbody//tr[contains(@class,'dataRow')]//th")
	private List<WebElement> contactList;

	public void clickOnContactsTab() {
		
		if(contacts.isDisplayed()) {
			contacts.click();
		}else {
			System.out.println("Contacts tab is not Dispalyed");
		}
		
	}


	public void clickNewBtn() {

		if(newBtn.isDisplayed()) {
			newBtn.click();
		}else {
			System.out.println("newBtn  is not Dispalyed");
		}
	}


	public boolean verifyContactEditPageIsDispalyed(WebDriver driver) {
		boolean isContactEditPageIsDispalyed=false;
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CONTACTS_EDIT_PAGE_TITLE)) {
			isContactEditPageIsDispalyed=true;
		}
		return isContactEditPageIsDispalyed;
	}


	public void enterLastName(String sLastName) {
		
		if(lastName.isDisplayed()) {
			lastName.clear();
			lastName.sendKeys(sLastName);
			
		}else {
			System.out.println("Last Name is not Dispalyed");
		}
	}


	public void clickAccountSearchImg(WebDriver driver) {
		if(accountName.isDisplayed()) {
			accountName.click();
			
			Set<String> windowHandles=driver.getWindowHandles();
			 
			 List<String> list=new ArrayList<String>(windowHandles);
			 
			 String parentWindowHandle=list.get(0);
			 
			 String childWindowHandle=list.get(1);
			 
			 driver.switchTo().window(childWindowHandle);
			
			
			driver.switchTo().frame(iFrameSearch);
			
			if(inputText.isDisplayed()) {
				
				inputText.sendKeys("*a");
			}
			else {
				System.out.println("inputText is not displayed");
			}
			if(goBtn.isDisplayed()) {
				goBtn.click();
			}else {
				System.out.println("Go btn is not displayed");
			}
			
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(iFrameResult);
			
			accountList.get(0).click();
			
			driver.switchTo().window(parentWindowHandle);
			
		}else {
			System.out.println("AccountSearchImg is not Dispalyed");
		}
	}


	public void clickSaveBtn() {
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}else {
			System.out.println("saveBtn  is not Dispalyed");
		}
		
	}


	public boolean verifyNewCantactCreated(WebDriver driver, String sLastName) {
		boolean isNewCantactCreated=false;
		if(lastNameText.isDisplayed()) {
			if(CommonUtils.waitForText(driver, lastNameText, sLastName)) {
				isNewCantactCreated=true;
			}
		}
		return isNewCantactCreated;
	}


	public void clickCreateNewView() {
		
		if(newViewBtn.isDisplayed()) {
			newViewBtn.click();
		}else {
			System.out.println("New view btn is not displayed");
		}
		
	}


	public boolean verifyCreateNewViewPageDispaled(WebDriver driver) {
		boolean isCreateNewViewPageDispaled=false;
		
		if(CommonUtils.waitForTitleOfThePage(driver, TitleConstants.CONTACTS_CREATE_NEW_VIEW_PAGE_TITLE)) {
			isCreateNewViewPageDispaled=true;
		}
		return isCreateNewViewPageDispaled;
	}


	public void enterViewName(String sViewName) {
		if(viewName.isDisplayed()) {
			viewName.clear();
			viewName.sendKeys(sViewName);
		}else {
			System.out.println("New view text is not displayed");
		}
	}


	public void enterViewUniqueName(String sViewUniqueName) {
		if(viewUniqueName.isDisplayed()) {
			viewUniqueName.clear();
			viewUniqueName.sendKeys(sViewUniqueName);
		}else {
			System.out.println("viewUniqueName text is not displayed");
		}
	}


	public boolean verifyCreatedNewViewNameDisplayedOnCantactsPage(String sViewName) {
		boolean isCreatedNewViewNameDisplayedOnCantactsPage=false;
		if(view.isDisplayed()) {
			Select s=new Select(view);
			if(s.getFirstSelectedOption().getText().equals(sViewName)) {
				isCreatedNewViewNameDisplayedOnCantactsPage=true;
			}
		}
		return isCreatedNewViewNameDisplayedOnCantactsPage;
	}


	public void selectRecentlyCreatedContacts(String sOption) {
		
		if(recentCont.isDisplayed()) {
			Select s=new Select(recentCont);
			s.selectByVisibleText(sOption);
		}else {
			System.out.println("Recently created option is not displayed");
		}
		
	}


	public boolean verifyRecenlyCeatedContactsAreDisplayed() {
		
		boolean isRecenlyCeatedContactsAreDisplayed=false;
		
		for(WebElement ele:contactList) {
			isRecenlyCeatedContactsAreDisplayed=true;
			System.out.println(ele.getText());
		}
		return isRecenlyCeatedContactsAreDisplayed;
	}
	
	
}
