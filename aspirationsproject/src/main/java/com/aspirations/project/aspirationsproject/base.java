package com.aspirations.project.aspirationsproject;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.internal.org.jline.utils.Log;
 
public class base {
	private static Logger log = Logger.getLogger(base.class);
	
public WebDriver driver;
	public WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public void invokeBrowser() {
		driver = init();
		driver.get("https://www.aspiration.com/");
	}
	public void searchProduct()	{
		driver.findElement(By.xpath("//a[@href='https://www.aspiration.com/our-products']")).click();
		log.info("Spend and Save link works");
	}

	public void findProduct() {
		String a = "";
		String b = "";
		a = driver.findElement(By.xpath("//div[@class='plan plan-original']/div[2]/h2")).getText();
		b = driver.findElement(By.xpath("//div[@class='plan plan-a-plus']/div[2]/h2")).getText();
		if(a.contains("Aspiration") && b.contains("Aspiration Plus"))
		{
			log.info("2 products can be seen");
		}
		else
		{
			log.info("One or both products not seen");
		}
	}
	
	public boolean inputField() {
		driver.findElement(By.xpath("//div[@class='plan plan-original']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")).click();
		driver.findElement(By.xpath("//div[@class='inside-form']/div/div/input")).click();
		return true;
	}
	
	public void closeinput() {
		driver.findElement(By.xpath("//div[@class='jwt-modal ng-scope']/button")).click();
	}
	
	public boolean radiobutton() {
		driver.findElement(By.xpath("//div[@class='plan plan-a-plus']/div[@class='plan-content']/button[@class='btn btn-v3 btn--blue ng-binding']")).click();
		return true;
	}
	
	public void wait10() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void verifyPlan() {
		  
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option selected']")));
			 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='option']")));

			String c = element.getText();
			String d = element1.getText();

		if(c.contains("$71.88 paid once yearly") && d.contains("$7.99 paid monthly"))
		{
			log.info("Radio Options Correct");
		}
		else
		{
			log.info("One or both radio options not correct");
		}
	}
		public void quit() {
			driver.quit();
		}
	}
		
	
	/*	public void verifyPlan() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 10);
		  WebElement wait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Col-favj32-0 sc-jSgupP jkeqlL eVYAHa']/div/ul/li/div/div/div/div/div/div/div/div[@class='h-display-flex']/a")));

	 * 
	 * 
		WebElement element = driver.findElement(By.xpath("//div[@class='option selected']"));
		WebElement element1 = driver.findElement(By.xpath("//div[@class='option']"));

		String c = element.getText();
		String d = element1.getText();
		
		System.out.println(c);
		System.out.println(d);

	if(c.contains("$71.88 paid once yearly") && d.contains("$7.99 paid monthly"))
	{
		System.out.println("Radio Option Correct");
	}
	else
	{
		System.out.println("One or both radio options not correct");
	}
}
*/
	

	
//	public void yearlyPayment() {
//		WebElement element = driver.findElement(By.xpath("//div[@class='option selected']/p"));
//		String a = element.getText();
//		if(a.contains("$71.88 paid once yearly"))
//		{
//			log.info("Text: " + a);
//		}
//		else
//		{
//			log.info("$71.88 paid once yearly not showing");
//		}
//	}
	
//	public void monthlyPayment() {
//		WebElement element = driver.findElement(By.xpath("//div[@class='option']/p"));
//		String a = element.getText();
//		if(a.contains("$7.99 paid monthly"))
//		{
//			log.info("Text: " + a);
//		}
//		else
//		{
//			log.info("$7.99 paid monthly");
//		}
//	}
	

