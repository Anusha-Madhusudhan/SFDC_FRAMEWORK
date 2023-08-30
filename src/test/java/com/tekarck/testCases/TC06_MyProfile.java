/**
 * 
 */
package com.tekarck.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.LoginPage;
import com.tekarck.pages.MyProfilePage;

/**
 * 
 */
public class TC06_MyProfile extends BaseTest {
	
	
	HomePage hp;
	MyProfilePage myProfilePage;
	
	
	/*Select user menu for <username> drop down[TC01]
	 * 
	 * Click "My profile" option from user menu
	 * 
	 * Click on edit profile button to edit contact information
	 * 
	 * Click on About tab and enter <Lastname> and click on save all button
	 */
	@Test
	void editMyProfile() throws InterruptedException {
		
		hp=new HomePage(driver);
		
		
		loginToSalesForceApp();
		
		hp.clickUserMenu();
		
		hp.clickMyProfile();
		
		Thread.sleep(2000);
		
		myProfilePage=new MyProfilePage(driver);
		
		Assert.assertTrue(myProfilePage.clickEditMyProfile(driver));
		
		myProfilePage.switchFrame(driver);
		
		myProfilePage.clickAboutTab();
		
		myProfilePage.setLastName("XXXX");
		
		myProfilePage.clickSaveAll(driver);
		
		Assert.assertTrue(myProfilePage.verifyEditedLastName("XXXX"));
		
		
//		hp.clickUserMenu();
//		
//		hp.clickLogOut();
		
		
		
	}
	
	/*
	 * Click on Post link, Enter the <text> to post in the post text area and click on share button
	 */
	@Test(dependsOnMethods = "editMyProfile")
	void postText(){
		
		
		myProfilePage.clickPost();
		
		myProfilePage.switchToPostFrame(driver);
		
		myProfilePage.setpostText("Hello welcome to java");
		
		driver.switchTo().defaultContent();
		
		myProfilePage.clickShare();
		
		
		
		Assert.assertTrue(myProfilePage.verifyPostText(driver,"Hello welcome to java"));
		
		
		
	}
	

	/*
	 * Click on the  file link and click on "upload a file from computer" button. 
	 * Click on choose file button and select a file to be uploaded and click open button.
	 */
	@Test(dependsOnMethods = "postText")
	void uploadFile(){
		
		myProfilePage.clickFile();
		myProfilePage.clickUpLoadFile(driver);
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\LoginTestData.xlsx";
		myProfilePage.sendFile(filePath);
		myProfilePage.clickShare();
		
		Assert.assertTrue(myProfilePage.verifyUploadedFileName(driver,"LoginTestData"));
		
	}
	
	/*
	 * Hover the mouse on myprofilephoto image and Add photo link appears. Click on the link to upload a photo. 
	 * Click on Choose file button and select the image to upload. Crop the photo to fit the image.
	 */
	@Test(dependsOnMethods = "uploadFile")
	void addPhoto(){
		
		myProfilePage.clickUploadPhoto(driver);
		myProfilePage.switchtoUploadPhotoIFrameID(driver);
		myProfilePage.sendphoto("C:\\Users\\anush\\OneDrive\\Desktop\\TekArch\\Dummy files\\th.jpg");
		
		myProfilePage.clickSaveBtn();
		
		driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")).click();
		
		driver.switchTo().defaultContent();
		
		
	}

}
