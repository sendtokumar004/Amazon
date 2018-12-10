package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	ExtentTest test;
	WebDriver driver = null;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	public void clicksearch() {
		searchbox.click();
		test.log(LogStatus.INFO, "Clicked on Search button");
	}

	public void setsearch(String search) {
		searchbox.sendKeys(search);

		test.log(LogStatus.INFO, " " + search);
	}

	@FindBy(xpath = "//input[@value='Go']")
	public WebElement go;

	public void go() {
		go.click();

	}

	@FindBy(xpath = "//span[contains(text(),'Hello. Sign in')]")
	public WebElement sign_in;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continue1;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElement pass;

	public void enter_user() {

		username.sendKeys("lokesh.kumar232@gmail.com");
		test.log(LogStatus.INFO, "  Enterned username +");

	}

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement login1;
	
	public  void clicklogin() {
		
		 String text=login1.getText();
		 //String actual1 ="Login";
		//Assert.assertEquals(text, actual1);
		test.log(LogStatus.INFO, "Login BUtton testcase ");
		
		login1.click();
		test.log(LogStatus.PASS, " Clicked on Login +");
	}
	

	public void enter_pass() {

		pass.sendKeys("123");
		test.log(LogStatus.INFO, "  Password Entered");

	}

}
