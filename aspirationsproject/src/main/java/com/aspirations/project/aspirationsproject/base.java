package com.aspirations.project.aspirationsproject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class base {
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
	}

	public void findProduct() {
		String a = "";
		String b = "";
		a = driver.findElement(By.xpath("//div[@class='plan plan-original']/div[2]/h2")).getText();
		b = driver.findElement(By.xpath("//div[@class='plan plan-a-plus']/div[2]/h2")).getText();
		if(a.contains("Aspiration") && b.contains("Aspiration Plus"))
		{
			System.out.println("2 products can be seen");
		}
		else
		{
			System.out.println("One or both products not seen");
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
	
	public void verifyPlan() {
		String c = "";
		String d = "";
		c = driver.findElement(By.xpath("//div[@class='option selected']/p/b")).getText();
		d = driver.findElement(By.xpath("//div[@class='option']/p/b")).getText();
		
	if(c.contains("$71.88 paid once yearly") && d.contains("$7.99 paid monthly"))
	{
		System.out.println("Radio Option Correct");
	}
	else
	{
		System.out.println("One or both radio options not correct");
	}
}
}
	/*
	public void getNthResult(int productNumber) {
		String xpathExpression = String.format("//div[@id='srp-river-results']/ul/li[%d]", productNumber);
		String nthProduct = driver.findElement(By.xpath(xpathExpression)).getText();
		System.out.println(nthProduct);
	}
	*/
/*	public void getAllProducts() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li/div/div[2]/a/h3"));
		List<WebElement> allProducts2 = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li/div/div[2]/div[3]/div[1]/span"));
		Iterator<WebElement> iteratorAllProducts = allProducts.iterator();
		Iterator<WebElement> iteratorAllProducts2 = allProducts2.iterator();
		while(iteratorAllProducts.hasNext() && iteratorAllProducts2.hasNext()) {
			WebElement product = iteratorAllProducts.next();
			WebElement product2 = iteratorAllProducts2.next();
			System.out.println(product.getText() + " - " + product2.getText());
			System.out.println("-----------------------");
		}
	}
	*/
