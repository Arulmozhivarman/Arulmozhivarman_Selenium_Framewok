package com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.DemoWebShop_POM.Home_Page;
import com.DemoWebShop_POM.Login_Page;
import com.DemoWebShop_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class base_Test {  
	
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	public FileUtility fileutility = new FileUtility();
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Welcome_Page welcomePage;
	public Login_Page loginPage;
	public Home_Page homePage;
	public WebDriverUtility webDriverUtility = new WebDriverUtility();

	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Database Connected");
	}
	
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("pre conditions");
		spark = new ExtentSparkReporter(FrameWorkConstant.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Address");

	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launch Browser");
				
//		String browser= fileutility.readDataFromPropertyFile("browserName");
//		String url = fileutility.readDataFromPropertyFile("url");
		
		String browser = System.getProperty("browserName");
		String url = System.getProperty("url");
		
// for commend promt OverAll		mvn test -DbrowserName=edge -Durl=https://demowebshop.tricentis.com/
//Select One class		mvn test -Dtest=Tc_001_verify_user_Is_Able_To_Add_Addresss_or_Not_Test
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			
			System.out.println("Enter valid Browser Name");
		}
		
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Login");
		welcomePage = new Welcome_Page(driver);
		welcomePage.getLoginLink().click();
		
		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginPage.getLoginButton().click();
		
		homePage = new Home_Page(driver);
	}
	
	
	
	@AfterSuite
	public void afterdSuite()
	{
		System.out.println("Database disconnected");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("post conditions");
		reports.flush();
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException
	{
		System.out.println("close Browser");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout");
		homePage.getLogoutButton().click();
	}

}

