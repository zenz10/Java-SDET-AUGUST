package pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	WebDriver driver;
	Logger loggerj = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/div/header/ul[1]/li[1]/a")
	WebElement spendSaveButton;
	
	public void clickOnSpendSave() {
		spendSaveButton.click();
		loggerj.info("Clicking on Spend & Save");
	}
	
}
