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

public class SearchPage {

	//Verify Page title 
	WebDriver driver = null;
	//h2[contains(text(),'OnePlus 6T')]

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h2[contains(text(),'OnePlus 6T')]")
	List<WebElement> oneplus;
	
	
	@FindBy(xpath="//div[contains(@class,'a-fixed-left-grid')]//span[contains(@class,'a-size-base a-color-price s-price a-text-bold')]")
	List<WebElement> price;
	
	
//Verify title of page conatins one plus 6T or not 	
	
}
