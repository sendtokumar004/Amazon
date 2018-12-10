package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Addtocart {
	WebDriver driver = null;
	//h2[contains(text(),'OnePlus 6T')]
	ExtentTest test;
	public Addtocart(WebDriver driver ,ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.test = test;
	}
	
	//input[@id='add-to-cart-button']
	
	@FindBy(id = "add-to-cart-button")
	 WebElement addtocart;
	public void clickonaddtocart() {
		
	addtocart.click();	
	test.log(LogStatus.INFO, "Clicked on Add to Cart button");
	
	}
	
	@FindBy(xpath="//h1[@class='a-size-medium a-text-bold']")
	WebElement Addedtocart;
	
	@FindBy(xpath="//a[@id='hlb-view-cart-announce']")
	WebElement cart;
	
	public void clickoncart() {
		
		cart.click();
		test.log(LogStatus.INFO, "Clicked on Cart button");
		
	}
	
	@FindBy(xpath="//h2[contains(text(),'Shopping Cart')]")
	WebElement ShoppingCart;
	}
	
