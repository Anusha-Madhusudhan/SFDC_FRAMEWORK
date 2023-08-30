package com.tekarck.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how = How.ID,using = "username")
	private WebElement userName;
	
	
	@FindBy(id = "password")
	private WebElement password;
	
	
	@FindBy(id="Login")
	private WebElement loginBtn;
	
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[@title='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='userNav']")
	private WebElement userMenuBtn;
	
	
	@FindBy(xpath ="//div[substring-before(@class,'remember')]//child::input")
	private WebElement rememberMe;
	
	
	@FindBy(xpath="//div[@class='w0 links bt pt16 mb20']//a")
	private WebElement forgotPassword;
	
	
	@FindBy(xpath ="//div[@id='error']")
	private WebElement errorMsg;
	
	@FindBy(xpath ="//div[@class='verifyform']//input[2]")
	private WebElement continueBtn;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	
	@FindBy(id = "un")
	public WebElement forgotPwdUserName;
	
	
	
	

	
	public String getSavedUserName() {
		
		String savedUserName;
		if(this.savedUsername.isDisplayed()) {
			savedUserName=this.savedUsername.getText();
		}
		else {
			savedUserName=null;
		}
		return savedUserName;
	}
	

	public void setUserName(String userName) {
		if(this.userName.isDisplayed()) {
			this.userName.clear();
		this.userName.sendKeys(userName);
		}
		else {
			System.out.println("User name is not diesplyed");
		}
	}

	
	public void setForgotPwdUserName(String userName) {
		if(this.forgotPwdUserName.isDisplayed()) {
			this.forgotPwdUserName.clear();
		this.forgotPwdUserName.sendKeys(userName);
		}
		else {
			System.out.println("User name is not diesplyed");
		}
	}

	

	public void setPassword(String password) {
		
		if(this.password.isDisplayed()) {
			this.password.clear();
			this.password.sendKeys(password);
			}
			else {
				System.out.println("Password is not diesplyed");
			}
		
	}

	

	public void clickLoginBtn() {
		
		if(this.loginBtn.isDisplayed()) {
			this.loginBtn.click();
		}else {
			System.out.println("Login btn is not displayed");
		}
		
	}
	
	
     public void clickLogoutBtn() {
    	 
    	 clickUserMenuBtn();
		
		if(this.logoutBtn.isDisplayed()) {
			this.logoutBtn.click();
		}else {
			System.out.println("Logout btn is not displayed");
		}
		
	}
     
     
     public void clickUserMenuBtn() {
 		
 		if(this.userMenuBtn.isDisplayed()) {
 			this.userMenuBtn.click();
 		}else {
 			System.out.println("User Menu btn is not displayed");
 		}
 		
 	}

	

	public void clickRememberMe() {
		
		if(this.rememberMe.isSelected()) {
			System.out.println("Remember me check bo already selected");
		}
		else {
			this.rememberMe.click();
		}
		
	}

	

	public void clickForgotPassword() {
		
		if(this.forgotPassword.isDisplayed()) {
			this.forgotPassword.click();
		}else {
			System.out.println("forgot password is not displayed");
		}
		
		
		
	}

	public String getErrorMsg() {
		
		String errorMsg;
		if(this.errorMsg.isDisplayed()) {
			errorMsg= this.errorMsg.getText();
		}
		else {
			errorMsg= null;
		}
		
		return errorMsg;
	}

	

	

	public void clickContinueBtn() {
		

		if(this.continueBtn.isDisplayed()) {
			this.continueBtn.click();
		}else {
			System.out.println("continue btn is not displayed");
		}
		
	}
	
	
	
	
	

}
