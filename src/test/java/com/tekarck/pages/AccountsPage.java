/**
 * 
 */
package com.tekarck.pages;

import java.util.List;

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
public class AccountsPage extends BasePage {
	
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#Account_Tab")
	private WebElement accountTab;
	
	@FindBy(xpath = "//div[@class='userBlock']//span")
	private WebElement userName;
	
	
	@FindBy(xpath = "//td[@class='pbButton']//input")
	private WebElement newBtn;
	
	
	@FindBy(css = "input#acc2")
	private WebElement accountName;
	
	
	@FindBy(css = "select#acc6")
	private WebElement type;
	
	
	@FindBy(xpath = "(//table[@class='detailList'])[3]//tbody//tr//td[2]//span//select[@id='00NHu00000PEMLd']")
	private WebElement customerPriority;
	
	
			
	@FindBy(xpath = "(//input[@value=' Save '])[2]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='bFilterView']//span[@class='fFooter']//a[2]")
	private WebElement creatNewView;
	
	@FindBy(css = "input#fname")
	private WebElement viewName;
	
	@FindBy(css = "input#devname")
	private WebElement viewUniqName;
	
	
    @FindBy(xpath = "//div[@class='controls']//select")
    private WebElement viewList;
    
    @FindBy(id = "fcf")
    WebElement viewDropDown;
    
    @FindBy(xpath = "//div[@class='bFilterView']//a[1]")
    private WebElement editView;
    
    @FindBy(css = "#fcol1")
	private WebElement field;
    
    @FindBy(css = "#fop1")
	private WebElement operator;
    
    @FindBy(css = "#fval1")
	private WebElement value;
    
    @FindBy(css = "#colselector_select_0")
	private WebElement availableFields;
    
    @FindBy(xpath = "(//div[@class='zen-mbs text']//a)[1]")
    private WebElement addBtn;
    
    @FindBy(xpath = "//div[@class='x-grid3-header-offset']//table//thead//tr//td//div")
    private List<WebElement> viewColumnNames;
    

	public void clickAccountTab() {
		if(accountTab.isDisplayed()) {
			accountTab.click();
		}else {
			System.out.println("Account Tab is not displayed");
		}
	}

	public boolean verifyAccountPageDisplayed(WebDriver driver) {
		boolean isaccountPageIsDisplayed=false;
		
		String expAccPageTitle=TitleConstants.ACCOUNTS_PAGE_TITLE;
		
		if(CommonUtils.waitForTitleOfThePage(driver, expAccPageTitle)) {
			isaccountPageIsDisplayed=true;
		}
			
		
		return isaccountPageIsDisplayed;
		
		
	}

	public void clickNewBtn(WebDriver driver) {
		
		if(newBtn.isDisplayed()) {
			if(CommonUtils.waitForElement(driver, newBtn)) {
				newBtn.click();
			}
		}else {
			System.out.println("New btn is not dispalyed");
		}
		
	}

	public void enterAccountName(String sAccountName) {
		
		if(accountName.isDisplayed()) {
			accountName.clear();
			accountName.sendKeys(sAccountName);
		}
		else {
			System.out.println("Account Name is not dispalyed");
		}
	}

	public void selectType(String sType) {
		if(type.isDisplayed()) {
			Select s=new Select(type);
			s.selectByValue(sType);
		}else {
			System.out.println("Type is not dispalyed");
		}
	}

	public void selectCustomerPriority(String sCustomerPriority) {
		
		if(customerPriority.isDisplayed()) {
			Select s=new Select(customerPriority);
			s.selectByValue(sCustomerPriority);
		}else {
			System.out.println("Customer Priority is not dispalyed");
		}
	}

	public void clickSaveBtn(WebDriver driver) {
		
		if(saveBtn.isDisplayed()) {
			if(CommonUtils.waitForElement(driver, saveBtn)) {
				saveBtn.click();
			}
		}else {
			System.out.println("save button is not dispalyed");
		}
	}

	
		public boolean verifyAccountEditPageDisplayed(WebDriver driver) {
			boolean isAccountEditPageIsDisplayed=false;
			
			String expAccEditPageTitle=TitleConstants.CREATE_NEW_ACCOUNT_PAGE_TITLE;
			
			if(CommonUtils.waitForTitleOfThePage(driver, expAccEditPageTitle)) {
				isAccountEditPageIsDisplayed=true;
			}
		return isAccountEditPageIsDisplayed;
	}

		public boolean verifyAccountIsCreatd(WebDriver driver,String sAccountName) {
			
			boolean isAccountCreated=false;
			
			if(CommonUtils.waitForTitleContais(driver, sAccountName)) {
				isAccountCreated=true;
			}
			return isAccountCreated;
		}

		public void clickCreateNewView(WebDriver driver) {
			
			if(creatNewView.isDisplayed()) {
				if(CommonUtils.waitForElement(driver, creatNewView)) {
					
					creatNewView.click();
				}
			}else {
				System.out.println("Create New View is not displayed");
			}
			
		}

		public boolean verifyCreateNewViewPageisDaisplayed(WebDriver driver) {
			boolean isTitlePresent=false;
			
			String expectedCreateNewViewPageTitle=TitleConstants.CREATE_NEW_VIEW_PAGE_TITLE;
			
			if(CommonUtils.waitForTitleOfThePage(driver, expectedCreateNewViewPageTitle)) {
				isTitlePresent=true;
			}
			
			return isTitlePresent;
		}

		public void enterViewName(String sViewName) {
			
			if(viewName.isDisplayed()) {
				viewName.clear();
				viewName.sendKeys(sViewName);
			}
			else {
				System.out.println("View Name is not displayed");
			}
		}

		public void enterViewUniqueName(String sViewUniqueName) {
			if(viewUniqName.isDisplayed()) {
				viewUniqName.clear();
				viewUniqName.sendKeys(sViewUniqueName);
			}
			else {
				System.out.println("View Unique Name is not displayed");
			}
		}

		public boolean verifyNewViewCreatedAndDisplyed(String sViewName) {
			boolean isNewViewCreated=false;
			
			if(viewList.isDisplayed()) {
				Select s=new Select(viewList);
				List<WebElement> selectedOps=s.getAllSelectedOptions();
				
				if(selectedOps.get(0).getText().equals(sViewName)) {
					isNewViewCreated=true;
				}
			}
			
			return isNewViewCreated;
		}

		public void selectViewNameToEdit(String sViewName) {
			
			if(viewDropDown.isDisplayed()){
				Select s=new Select(viewDropDown);
				s.selectByVisibleText(sViewName);
			}else {
				System.out.println("View drop down is not displayed");
			}
			
		}

		public void clickEdit() {
			
			if(editView.isDisplayed()) {
				
				editView.click();
				
			}else {
				System.out.println("Edit Btn is not displayed");
			}
			
		}

		public boolean verifyViewNameToBeEditedOnEditPage(WebDriver driver, String sViewName) {
			boolean isViewNameDisplayed=false;
			
			if(viewName.isDisplayed()) {
				if(viewName.getAttribute("value").equals(sViewName)) {
					isViewNameDisplayed=true;
				}
				
			}else {
				System.out.println("View List is not displayed");
			}
			
			return isViewNameDisplayed;
		}

		public void enterNewVieName(String sNewViewName) {
			if(viewName.isDisplayed()) {
				viewName.clear();
				viewName.sendKeys(sNewViewName);
			}else {
				System.out.println("View name is not displayed");
			}
			
		}

		public void selectField(String sField) {
			if(field.isDisplayed()){
				Select s=new Select(field);
				s.selectByVisibleText(sField);
			}else {
				System.out.println("field is not displayed");
			}
			
		}

		public void selectOperator(String sOperator) {
			if(operator.isDisplayed()){
				Select s=new Select(operator);
				s.selectByVisibleText(sOperator);
			}else {
				System.out.println("operator is not displayed");
			}
		}

		public void enterValue(String sValue) {
			if(value.isDisplayed()) {
				value.clear();
				value.sendKeys(sValue);
			}else {
				System.out.println("Value text is not displayed");
			}
		}

		public void selectAvailabeFields(String sAvailableFieldOption) {
			if(availableFields.isDisplayed()){
				Select s=new Select(availableFields);
				s.selectByVisibleText(sAvailableFieldOption);
			}else {
				System.out.println("AvailableFieldOption is not displayed");
			}
		}

		public void clickAddBtn() {
			
			if(addBtn.isDisplayed()) {
				addBtn.click();
			}else {
				System.out.println("add button is not displayed");
			}
			
		}

		public boolean verifyTheEditedNewViewNameDisplayed(String sEditedNewViewName) {
			boolean isTheEditedNewViewNameDisplayed=false;
			
			if(viewList.isDisplayed()) {
				Select s=new Select(viewList);
				if(s.getFirstSelectedOption().getText().equals(sEditedNewViewName)) {
					isTheEditedNewViewNameDisplayed=true;
				}
			}
			
			return isTheEditedNewViewNameDisplayed;
		}

		public boolean verifyTheColumnAddedToViewTable(String sLastColoumnName) {
			boolean isTheColumnAddedToViewTable=false;
			
			for(WebElement ele:viewColumnNames) {
				if(ele.getText().equals(sLastColoumnName)) {
					isTheColumnAddedToViewTable=true;
					break;
				}
			}
			
			return isTheColumnAddedToViewTable;
		}
	
	
	

}
