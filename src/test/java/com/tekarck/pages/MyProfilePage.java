/**
 * 
 */
package com.tekarck.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tekarch.utils.CommonUtils;




/**
 * 
 */
public class MyProfilePage extends BasePage {
	
	
   public MyProfilePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
 
//	@FindBy(xpath="(//h3//div[@class='vfButtonBarButton']//div//a)[1]")
   
   @FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
   private WebElement editProfile;
	
//	private String editProfileFrame="contactInfoContentId";
   
   
   @FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
   WebElement profilePage;
	
	@FindBy(id="contactInfoContentId")
	private WebElement editProfileFrame;
	
	@FindBy(id="aboutTab")
	private WebElement aboutTab;
	
	@FindBy(id="lastName")
	private WebElement lastName;

	@FindBy(xpath="//input[@value='Save All']")
	private WebElement saveAllBtn;
	
	@FindBy(css = ".publisherattachtext ")
	WebElement post;
	
	@FindBy(css = ".cke_wysiwyg_frame.cke_reset")
	WebElement postiFrame;
	
	@FindBy(xpath = "/html/body")
	WebElement postText;
	
	@FindBy(id = "publishersharebutton")
	WebElement share;
	
	@FindBy(xpath = "//span[@class='publisherattachtext ' and text()='File']")
	WebElement file;
	
	@FindBy(xpath = "//a[@id='chatterUploadFileAction']")
	WebElement upLoadFile;
	
	@FindBy(xpath = "//input[@class='file']")
	WebElement chooseFile;
	
	@FindBy(id = "uploadLink")
	WebElement uploadPhoto;
	
	//String uploadPhotoIFrameID="uploadPhotoContentId";
	
	@FindBy(id="uploadPhotoContentId")
	private WebElement uploadPhotoFrame;
	
	@FindBy(xpath = "//form[@id='j_id0:uploadFileForm']//input[@class='fileInput']")
	WebElement choosePhoto;
	
	@FindBy(xpath = "(//input[@id='j_id0:uploadFileForm:uploadBtn'])[1]")
	WebElement saveBtn;
	
	@FindBy(css = "#tailBreadcrumbNode")
	WebElement verifyLastName;
	
	@FindBy(xpath = "//span[@class='contentTitleLink']")
	WebElement uploadedFileName;
	
	
	
	@FindBy(xpath = "//span[@class='feeditemtext cxfeeditemtext']//p")
	WebElement lastPost;
	
	
	
	public void clickSaveBtn() {
		if(saveBtn.isDisplayed()) {
			saveBtn.click();
		}
	}
	
	public void switchtoUploadPhotoIFrameID(WebDriver driver) {
		
		if(uploadPhotoFrame.isDisplayed()){
			
			driver=CommonUtils.waitForFrameToBeAvailableToSwitch(driver, uploadPhotoFrame);
			
		}else {
			System.out.println("Upload Photo frame is not displayed");
		}
		
	}
	
	
	
	public void clickUploadPhoto(WebDriver driver) {
		if(uploadPhoto.isDisplayed()) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", uploadPhoto);
		}else {
			System.out.println("uoload photo is not displayed");
		}
	}
	
	public void sendphoto(String filePath) {
		if(choosePhoto.isDisplayed()) {
			choosePhoto.sendKeys(filePath);
		}else {
			System.out.println("chooseFile is not displayed");
		}
	}
	
	
	public void clickFile() {
		if(file.isDisplayed()) {
			file.click();
		}else {
			System.out.println("File is not displayed");
		}
	}
	
	public void clickUpLoadFile(WebDriver driver) {
		if(upLoadFile.isDisplayed()) {
			
			if(CommonUtils.waitForElement(driver, upLoadFile)) {
				
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", upLoadFile);
//			upLoadFile.click();
			}else {
				System.out.println("upload file is not clickable");
			}
		}else {
			System.out.println("uoload File is not displayed");
		}
	}
	
	
	public void sendFile(String filePath) {
		
		if(chooseFile.isDisplayed()) {
			chooseFile.sendKeys(filePath);
		}else {
			System.out.println("chooseFile is not displayed");
		}
		
	}
	
	
	public void clickPost() {
		if(post.isDisplayed()) {
			post.click();
		}else {
			System.out.println("post is not displayed");
		}
	}
	
	public void switchToPostFrame(WebDriver driver) {
		
		if(postiFrame.isDisplayed()) {
			driver=CommonUtils.waitForFrameToBeAvailableToSwitch(driver, postiFrame);
		}else {
			System.out.println("postiFrame is not displayed");
		}
		
		
	}
	
	public void setpostText(String text) {
		if(postText.isDisplayed()) {
			postText.clear();
			postText.sendKeys(text);
			
		}else {
			System.out.println("post text is not displayed");
		}
	}
	
	
	public void clickShare() {
		if(share.isDisplayed()) {
			share.click();
		}else {
			System.out.println("share post is not displayed");
		}
	}
	
	
	public boolean clickEditMyProfile(WebDriver driver) {
		
		boolean flag=true;
		
		if(editProfile.isDisplayed()) {
			
		if(CommonUtils.waitForElement(driver, editProfile)) {
			
//			JavascriptExecutor js=(JavascriptExecutor) driver;
//			js.executeScript("arguments[0].click();", editProfile);
     		editProfile.click();
			}
		else {
			System.out.println("Edit button is not clickable");
			flag=false;
		}
		
		}else {
			System.out.println("Edit button is not displayed");
			flag=false;
		}
		
		return flag;
		
	}
	
	public void switchFrame(WebDriver driver) {
		
		if(editProfileFrame.isDisplayed()) {
			
			driver=CommonUtils.waitForFrameToBeAvailableToSwitch(driver, editProfileFrame);
			
		}
		else {
			System.out.println("Frame is not displayed");
		}
		
		
		
	}
	
	public void clickAboutTab() {
		if(aboutTab.isDisplayed()) {
		
			aboutTab.click();
		}
		else {
			System.out.println("About tab is not displayed");
		}
	}
	

	public void setLastName(String lName) {
		
		if(lastName.isEnabled()) {
			
			lastName.clear();
			lastName.sendKeys(lName);
		}
		else {
			System.out.println("Last name is not displayed");
		}
		
	}
	
	
	public void clickSaveAll(WebDriver driver) {
		if(saveAllBtn.isEnabled()) {
			saveAllBtn.click();
			driver.switchTo().parentFrame();
		}
		else {
			System.out.println("save all is not displayed");
		}
	}

	public boolean verifyEditedLastName(String expectedLastName) {
		
		boolean isLastNameUpdated=false;
		
		if(verifyLastName.isDisplayed()) {
			
			String actualLastName=verifyLastName.getText();
			
			if(actualLastName.contains(expectedLastName)) {
				
				isLastNameUpdated=true;
				
			}
			
		}else {
			System.out.println("Last name is not displayed");
		}
		
		return isLastNameUpdated;
		
	}

	public boolean verifyPostText(WebDriver driver, String expextedPostText) {
		
		boolean isPostTextUpdated=false;
		
		if(lastPost.isDisplayed()) {
			
			if(CommonUtils.waitForText(driver, lastPost, expextedPostText)) {
//				String actualPost=lastPost.getText();
//				System.out.println(actualPost);
//				if(actualPost.equals(expextedPostText)) {
					isPostTextUpdated=true;
//				}
				
			}
			
		}
		else {
			System.out.println("Post is not displayed");
		}
		
		return isPostTextUpdated;
	}

	public boolean verifyUploadedFileName(WebDriver driver, String sFileName) {
		
     boolean isFileUploaded=false;
		
		if(uploadedFileName.isDisplayed()) {
			
			if(CommonUtils.waitForText(driver, uploadedFileName, sFileName)) {
				isFileUploaded=true;
			}
			
//			String actualFileName=uploadedFileName.getText();
//			System.out.println(actualFileName);
//			if(actualFileName.equals(sFileName)) {
//				isFileUploaded=true;
//			}
		}
		else {
			System.out.println("Post is not displayed");
		}
		
		return isFileUploaded;
	}

	public boolean isMyProfilePageIsVisible() {
		boolean isMyProfilePageIsVisible=false;
		
		if(profilePage.isDisplayed()) {
			isMyProfilePageIsVisible=true;
		}
		return isMyProfilePageIsVisible;
	}

	public WebElement getProfilePage() {
		
		return profilePage;
	}

	
}
