package pageObjects;

public interface ProductsPageElements {
	String aspirationText = "//div[@class='plan plan-original']/div[2]/h2";
	String aspirationPlusText = "//div[@class='plan plan-a-plus']/div[2]/h2";
	String getAspirationButton = "//div[@class='plan plan-original']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']";
	String getAspirationTextbox = "//div[@class='inside-form']/div/div/input";
	String getAspirationPopupExitButton = "//div[@class='jwt-modal ng-scope']/button";
	String getAspirationPlusButton = "//div[@class='plan plan-a-plus']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']";
	String yearlyText = "/html/body/div[1]/div/div/div/div[2]/div[1]/p";
	String monthyText = "/html/body/div[1]/div/div/div/div[2]/div[2]/p";
}
