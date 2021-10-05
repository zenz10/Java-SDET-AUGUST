package pageEvents;

import pageObjects.HomePageElements;
import test.BaseTest;
import utils.ElementFetch;

public class HomePageEvents {
	
	//navigating from the home page to our products page via the “Spend & Save” link at the top of the home page
	public void clickOnSpendSave() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.logger.info("Clicking on Spend & Save");
		elementFetch.getWebElement("XPATH", HomePageElements.spendSaveButton).click();
	}
}
