package com.amazonTesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;

public class Testcases {

	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	com.relevantcodes.extentreports.ExtentTest test;

	@BeforeClass
	public void beforeClass() {

		baseUrl = "http://www.amazon.in/";
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		test = report.startTest("Amazon Testcases");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		test.log(LogStatus.INFO, "Browser Started...");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}

	@Test(priority = 1)
	public void homepage() throws Exception {
		HomePage hp = new HomePage(driver, test);
		String title = driver.getTitle();
		String Expected_title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("" + title);
		test.log(LogStatus.PASS, "" + title);

	}

	@Test(priority = 2)
	public void Login() throws Exception {

		HomePage hp = new HomePage(driver, test);

		try {

			Thread.sleep(10000);
			hp.sign_in.click();

			String actual = driver.getTitle();
			test.log(LogStatus.PASS, "" + actual);
			String expected = "Amazon Sign In";
			Assert.assertEquals(actual, expected);
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}
		// Assert.assertEquals(actual, expected);
		test.log(LogStatus.PASS, "Clicked on Sign in");
	}

	@Test(priority = 3)
	public void username() throws Exception {
		HomePage hp = new HomePage(driver, test);

		try {

			hp.enter_user();

			;
		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}
		test.log(LogStatus.PASS, "username Entered Sucessfully");

		hp.continue1.click();
		test.log(LogStatus.PASS, "Clicked on Continue");
	}

	@Test(priority = 4)

	public void pass() throws Exception {

		HomePage hp = new HomePage(driver, test);

		try {
			hp.enter_pass();
			hp.clicklogin();

		}

		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());

		}
	
		
		String actual_title1=driver.getTitle();
		String Expected_title1="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actual_title1, Expected_title1);
		test.log(LogStatus.PASS, "Login and Password testcase sucessfully Passed");
		

	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}

	}

	@AfterClass

	public void last() throws IOException {

		driver.quit();
		report.endTest(test);
		report.flush();

	}

}
