/**
 * 
 */
package com.tekarck.testCases;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.teckarck.constants.FileConstants;
import com.tekarch.listeners.SFDC_Listener;
import com.tekarch.utils.ExcelUtils;
import com.tekarch.utils.FileUtils;
import com.tekarck.pages.HomePage;
import com.tekarck.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 */
public class BaseTest {
	
	Logger logger;
	
//	private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	 static WebDriver driver;
	
	
//	static WebDriver driver;
//	WebDriverWait wait;
//	ExtentReports extent=new ExtentReports();
//	ExtentSparkReporter spark=null;
//	ExtentTest test=null;
	 
	/*
	 * @BeforeMethod void report(Method mName) { extent.attachReporter(spark);
	 * spark=new ExtentSparkReporter(new File(FileConstants.TEST_REPORT_FILE_PATH));
	 * spark.config().setDocumentTitle("Sales Force Application");
	 * spark.config().setReportName("Functional Testing");
	 * spark.config().setTheme(Theme.STANDARD);
	 * 
	 * 
	 * extent.setSystemInfo("Application", "Sales Force Application");
	 * extent.setSystemInfo("Environment", "QA Environment");
	 * extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	 * extent.setSystemInfo("Tester Name", "Anusha");
	 * test=extent.createTest(mName.getName());
	 * 
	 * }
	 */
	
	
	@Parameters({"browser","URL"})
	@BeforeClass
	void setUp(@Optional("chrome")String br,@Optional("https://login.salesforce.com/")String appln) throws IOException {
		logger=LogManager.getLogger(this.getClass().getName());
		logger.info("Set driver : "+br);
//		SFDC_Listener.test.info("Set driver   :"+br);
		
		/*
		 * PARAMETERIZATION from testNG.xml file
		 */
	    driver=getBrowserType(br);
		driver.get(appln);
		logger.info("Launching the application : "+appln);
		/*
		 * Parameter from properties file
		 */
//		driver=BaseTest.getBrowserType(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"browser"));
//		threadLocal.set(driver);
//		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//		driver.get(FileUtils.readPropertiesFile(FileConstants.TEST_DATA_PROPERTIES_FILE_PATH,"URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	}

	@AfterClass
	void tearDown() {
		
		driver.close();
		logger.info("Closing the browser :");
//     	threadLocal.remove();
	}

	private  WebDriver getBrowserType(String browser) {
		
		String brName=browser.toLowerCase();
		WebDriver driver;
		
		switch (brName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=  new FirefoxDriver();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver=  new SafariDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=  new EdgeDriver();
			break;

		default:
			System.out.println("Provide valid browser name");
			driver=  null;
		}
		
		return driver;
		
	}
	
	
	
	    public static WebDriver getDriver() {
//		return threadLocal.get();
		   return driver;
	}






	void loginToSalesForceApp() {
		LoginPage lp=new LoginPage(getDriver());
		try {
		lp.setUserName(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "userName"));
		lp.setPassword(FileUtils.readPropertiesFile(FileConstants.LOGIN_TEST_DATA_PROPERTIES_FILE_PATH, "password"));
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lp.clickLoginBtn();
	}
	
	/*
	 * @AfterMethod void flush() { extent.flush(); }
	 */
	
	
	
	
  
  
  
  




	

}
