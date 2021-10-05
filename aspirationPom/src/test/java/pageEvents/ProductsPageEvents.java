package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageElements;
import pageObjects.ProductsPageElements;
import test.BaseTest;
import utils.ElementFetch;

public class ProductsPageEvents {
	WebDriverWait wait = new WebDriverWait(BaseTest.driver,30);
	
//	Verify that you see 2 card products, Aspiration and Aspiration Plus
	public void findProducts() {
		ElementFetch elementFetch = new ElementFetch();
		String aspOrig = elementFetch.getWebElement("XPATH", ProductsPageElements.aspirationText).getText();
		String aspPlus = elementFetch.getWebElement("XPATH", ProductsPageElements.aspirationPlusText).getText();
		if(aspOrig.contains("Aspiration") && aspPlus.contains("Aspiration Plus"))
		{
			BaseTest.logger.info("Aspiration and Aspiration Plus seen");
		}
		else if(aspOrig.contains("Aspiration"))
		{
			BaseTest.logger.info("Only Aspiration Seen");
		}
		else if(aspPlus.contains("Aspiration Plus"))
		{
			BaseTest.logger.info("Only Aspiration Plus Seen");
		}
		else
		{
			BaseTest.logger.info("Aspiration and Aspiration Plus not seen");
		}
	}
	
//	Verify that when you click Get Aspiration - A modal containing an input field for an email address to sign up appears
	public void clickGetAspirationFillInput() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.logger.info("Clicking Get Aspiration and checking input field");
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationButton).click();
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationTextbox).sendKeys("InputTest");
	}
	
	public void exitGetAspirationPopup() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.logger.info("Exiting Get Aspiration Popup");
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationPopupExitButton).click();
	}
//	Verify that when you click Get Aspiration Plus - A modal with monthly and yearly plans appears
	public void clickGetAspirationPlus() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.logger.info("Clicking Get Aspiration Plus");
		elementFetch.getWebElement("XPATH", ProductsPageElements.getAspirationPlusButton).click();
	}
	
//	Verify that yearly radio option is $71.88 paid once yearly and that monthly radio option is $7.99 paid monthly
	public void VerifyYearlyAndMonthlyPlan() {
		ElementFetch elementFetch = new ElementFetch();
		WebElement yearly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductsPageElements.yearlyText)));
		WebElement monthly = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductsPageElements.monthyText)));
		String yearlytext = yearly.getText();
		String monthlytext = monthly.getText();
		if(yearlytext.contains("$71.88 paid once yearly") && monthlytext.contains("$7.99 paid monthly"))
		{
			BaseTest.logger.info("Yearly and Monthly radio option verified");
		}
		else if(yearlytext.contains("$71.88 paid once yearly"))
		{
			BaseTest.logger.info("Only yearly text seen");
		}
		else if(monthlytext.contains("$7.99 paid monthly"))
		{
			BaseTest.logger.info("Only monthly text seen");
		}
		else
		{
			BaseTest.logger.info("Yearly and Monthly radio option not verified");
		}
	}
}