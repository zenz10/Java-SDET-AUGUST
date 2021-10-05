package mainutils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFetch {
	public WebElement getWebElement(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "ID":
			return SetupDriver.driver.findElement(By.id(identifierValue));
		case "CSS":
			return SetupDriver.driver.findElement(By.cssSelector(identifierValue));
		case "TAGNAME":
			return SetupDriver.driver.findElement(By.tagName(identifierValue));
		case "XPATH":
			return SetupDriver.driver.findElement(By.xpath(identifierValue));
			default:
				return null;
		}
	}
	public List<WebElement> getListWebElement(String identifierType, String identifierValue) {
		switch(identifierType) {
		case "ID":
			return SetupDriver.driver.findElements(By.id(identifierValue));
		case "CSS":
			return SetupDriver.driver.findElements(By.cssSelector(identifierValue));
		case "TAGNAME":
			return SetupDriver.driver.findElements(By.tagName(identifierValue));
		case "XPATH":
			return SetupDriver.driver.findElements(By.xpath(identifierValue));
			default:
				return null;
		}
	}
}
