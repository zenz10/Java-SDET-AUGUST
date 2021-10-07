package pageObjects;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.Steps;

public class ProductsPage {
	public static WebDriver driver;
	private static Logger loggerj = LogManager.getLogger(ProductsPage.class);
	public static WebDriverWait wait = new WebDriverWait(Steps.driver,30);
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}
	
	@FindBy(xpath="//div[@class='plan plan-original']/div[2]/h2")	WebElement aspirationText;
	@FindBy(xpath="//div[@class='plan plan-a-plus']/div[2]/h2")	WebElement aspirationPlusText;
	@FindBy(xpath="//div[@class='plan plan-original']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")	WebElement getAspirationButton;
	@FindBy(xpath="//div[@class='inside-form']/div/div/input")	WebElement getAspirationTextbox;
	@FindBy(xpath="//div[@class='jwt-modal ng-scope']/button")	WebElement getAspirationPopupExitButton;
	@FindBy(xpath="//div[@class='plan plan-a-plus']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")	WebElement getAspirationPlusButton;
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[1]/p")	WebElement yearlyText;
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[2]/p")	WebElement monthlyText;
	
	public void findProducts(String product1, String product2) {
		String aspOrig = aspirationText.getText();
		String aspPlus = aspirationPlusText.getText();
		if(aspOrig.contains(product1) && aspPlus.contains(product2))
		{
			loggerj.info("Aspiration and Aspiration Plus seen: " + aspOrig + " and " +aspPlus);
		}
		else if(aspOrig.contains("Aspiration"))
		{
			loggerj.info("Only Aspiration Seen");
		}
		else if(aspPlus.contains("Aspiration Plus"))
		{
			loggerj.info("Only Aspiration Plus Seen");
		}
		else
		{
			loggerj.info("Aspiration and Aspiration Plus not seen");
		}
	}
	
	public void clickGetAspiration() {
		getAspirationButton.click();
		loggerj.info("Clicking Get Aspiration");
	}
	
	public void clickGetAspirationFillInput(String email) {
		getAspirationTextbox.sendKeys(email);
		loggerj.info("Checking input field");
	}
	
	public void exitGetAspirationPopup() {
		getAspirationPopupExitButton.click();
		loggerj.info("Exiting Get Aspiration Popup");
	}
	
	public void clickGetAspirationPlus() {
		getAspirationPlusButton.click();
		loggerj.info("Clicking Get Aspiration Plus");
	}
	
	public void VerifyYearlyAndMonthlyPlan(String yearlyprice, String monthlyprice) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String yearlytext = yearlyText.getText();
		String monthlytext = monthlyText.getText();
		if(yearlytext.contains(yearlyprice) && monthlytext.contains(monthlyprice))
		{
			loggerj.info("Yearly and Monthly radio option verified: " + yearlytext + " and " + monthlytext);
		}
		else if(yearlytext.contains(yearlyprice))
		{
			loggerj.info("Only yearly text seen");
		}
		else if(monthlytext.contains(monthlyprice))
		{
			loggerj.info("Only monthly text seen");
		}
		else
		{
			loggerj.info("Yearly and Monthly radio option not verified");
		}
	}
}