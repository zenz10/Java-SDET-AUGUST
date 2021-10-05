package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageObjects.HomePageElements;
import test.BaseTest;
import utils.ElementFetch;

public class HomePageEvents {
	
	private static Logger logger = LogManager.getLogger(HomePageEvents.class);
	
	//navigating from the home page to our products page via the “Spend & Save” link at the top of the home page
	public void clickOnSpendSave() {
		ElementFetch elementFetch = new ElementFetch();
		BaseTest.logger.info("Clicking on Spend & Save");
		logger.info("Clicking on Spend & Save");
		elementFetch.getWebElement("XPATH", HomePageElements.spendSaveButton).click();
	}
}
