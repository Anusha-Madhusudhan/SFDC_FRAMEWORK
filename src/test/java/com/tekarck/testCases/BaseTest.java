/**
 * 
 */
package com.tekarck.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.teckarck.constants.FileConstants;
import com.tekarch.utils.ExcelUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.LoginPage;


/**
 * 
 */
public class BaseTest {
	
//	private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	WebDriver driver;
	WebDriverWait wait;
	 
	
	@BeforeClass
	void setDriver() throws IOException {

		
	    driver=BaseTest.getDriver(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"browser"));
//		threadLocal.set(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	}



	private static WebDriver getDriver(String browser) {
		
		String brName=browser.toLowerCase();
		
		switch (brName) {
		case "chrome":
			return new ChromeDriver();
		case "firefox":
			return new FirefoxDriver();
		case "safari":
			return new SafariDriver();
			
		case "edge":
			return new EdgeDriver();
			

		default:
			System.out.println("Provide valid browser name");
			return null;
		}
		
		
		
	}
	
	
	   void loginToSalesForceApp() {
		LoginPage lp=new LoginPage(driver);
		try {
		lp.setUserName(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "userName"));
		lp.setPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "password"));
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lp.clickLoginBtn();
	}
	
	
	@AfterClass
	void closeDriver() {
		driver.quit();
//		threadLocal.remove();
	}
	
	

}
