package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mainutils.ElementFetch;
import mainutils.SetupDriver;
import pageObjects.HomePageElements;

public class HomePageEvents extends SetupDriver{
	
	private static Logger loggerj = LogManager.getLogger(HomePageEvents.class);
	
	//navigating from the home page to our products page via the “Spend & Save” link at the top of the home page
	public void clickOnSpendSave() {
		ElementFetch elementFetch = new ElementFetch();
		logger.info("Clicking on Spend & Save");
		loggerj.info("Clicking on Spend & Save");
		elementFetch.getWebElement("XPATH", HomePageElements.spendSaveButton).click();
	}
}
