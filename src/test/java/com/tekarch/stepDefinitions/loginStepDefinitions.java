/**
 * 
 */
package com.tekarch.stepDefinitions;

import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;

import com.teckarck.constants.TitleConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 */
public class loginStepDefinitions extends BaseStepDefinsClass{
	
	
	
	@Before
	public void setUp() {
		
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		
	}
	
	@Given("Launch App {string}")
	public void launch_app(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   
	}
	@When("User enters User Name {string}")
	public void user_enters_user_name(String uName) {
		
		lp.setUserName(uName, driver);
		
		
	}
	@When("User clears the Password field")
	public void user_clears_the_password_field() {
		lp.setPassword("", driver);
	}
	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		lp.clickLoginBtn(driver);
	}
	
	@When("User enters Password {string}")
	public void user_enters_password(String password) {
	    lp.setPassword(password, driver);
	}
	
	@Then("User should be navigated to Home page")
	public void user_should_be_navigated_to_home_page() {
		String expectedPagetitle = TitleConstants.HOME_PAGE_TITLE;
		boolean flag = CommonUtils.waitForTitleOfThePage(driver, expectedPagetitle);
		Assert.assertTrue(flag);
	}
	
	@Then("User should see the error message {string} should be displayed")
	public void user_should_see_the_error_message_should_be_displayed(String errorMsg) {
		boolean isErrorMsgPresent=lp.isErrorMsgDisaplyed(driver,errorMsg);
		Assert.assertTrue(isErrorMsgPresent);
	}
	
	@After
	@Then("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}
	
	




}
