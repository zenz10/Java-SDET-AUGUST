package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mainutils.ElementFetch;
import mainutils.SetupDriver;
import pageObjects.HomePageElements;
import pageObjects.ProductsPageElements;

public class ProductsPageEvents extends SetupDriver{
	
	private static Logger loggerj = LogManager.getLogger(ProductsPageEvents.class);
	public static WebDriverWait wait = new WebDriverWait(SetupDriver.driver,30);

//	Verify that you see 2 card products, Aspiration and Aspiration Plus
	public void findProducts(String product1, String product2) {
		ElementFetch elementFetch = new ElementFetch();
		String aspOrig = elementFetch.getWebElement("XPATH", ProductsPageElements.aspirationText).getText();
		String aspPlus = elementFetch.getWebElement("XPATH", ProductsPageElements.aspirationPlusText).getText();
		if(aspOrig.contains(product1) && aspPlus.contains(product2))
		{
			logger.info("Aspiration and Aspiration Plus seen");
			loggerj.info("Aspiration and Aspiration Plus seen: " + aspOrig + " and " +aspPlus);
		}
		else if(aspOrig.contains("Aspiration"))
		{
			logger.info("Only Aspiration Seen");
			loggerj.info("Only Aspiration Seen");
		}
		else if(aspPlus.contains("Aspiration Plus"))
		{
			logger.info("Only Aspiration Plus Seen");
			loggerj.info("Only Aspiration Plus Seen");
		}
		else
		{
			logger.info("Aspiration and Aspiration Plus not seen");
			loggerj.info("Aspiration and Aspiration Plus not seen");
		}
	}
	
//	Verify that when you click Get Aspiration - A modal containing an input field for an email address to sign up appears
	public void clickGetAspirationFillInput(String email) {
		ElementFetch elementFetch = new ElementFetch();
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationButton).click();
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationTextbox).sendKeys(email);
		logger.info("Clicking Get Aspiration and checking input field");
		loggerj.info("Clicking Get Aspiration and checking input field");
	}
	
	public void exitGetAspirationPopup() {
		ElementFetch elementFetch = new ElementFetch();
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationPopupExitButton).click();
		logger.info("Exiting Get Aspiration Popup");
		loggerj.info("Exiting Get Aspiration Popup");
	}
//	Verify that when you click Get Aspiration Plus - A modal with monthly and yearly plans appears
	public void clickGetAspirationPlus() {
		ElementFetch elementFetch = new ElementFetch();
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationPlusButton).click();
		logger.info("Clicking Get Aspiration Plus");
		loggerj.info("Clicking Get Aspiration Plus");
	}
	
//	Verify that yearly radio option is $71.88 paid once yearly and that monthly radio option is $7.99 paid monthly
	public void VerifyYearlyAndMonthlyPlan(String yearlyprice, String monthlyprice) {
		ElementFetch elementFetch = new ElementFetch();
		WebElement yearly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductsPageElements.yearlyText)));
		WebElement monthly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductsPageElements.monthyText)));
		String yearlytext = yearly.getText();
		String monthlytext = monthly.getText();
		if(yearlytext.contains(yearlyprice) && monthlytext.contains(monthlyprice))
		{
			logger.info("Yearly and Monthly radio option verified");
			loggerj.info("Yearly and Monthly radio option verified: " + yearlytext + " and " + monthlytext);
		}
		else if(yearlytext.contains(yearlyprice))
		{
			logger.info("Only yearly text seen");
			loggerj.info("Only yearly text seen");
		}
		else if(monthlytext.contains(monthlyprice))
		{
			logger.info("Only monthly text seen");
			loggerj.info("Only monthly text seen");
		}
		else
		{
			logger.info("Yearly and Monthly radio option not verified");
			loggerj.info("Yearly and Monthly radio option not verified");
		}
	}
}