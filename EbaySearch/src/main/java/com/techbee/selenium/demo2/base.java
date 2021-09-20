package com.techbee.selenium.demo2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class base {

	public WebDriver driver;
	public WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public void invokeBrowser() {
		driver = init();
		driver.get("https://www.ebay.com/");
	}
	
	public void searchProduct (String product, String category)	{
		driver.findElement(By.id("gh-ac")).sendKeys(product);
		
		WebElement categoryDropdownElement = driver.findElement(By.id("gh-cat"));
		
		Select categorySelect = new Select(categoryDropdownElement);
		
		categorySelect.selectByVisibleText(category);
		
		driver.findElement(By.id("gh-btn")).click();
		
		String result = driver.findElement(By.xpath("//h1[contains(text(),'results for')]")).getText();
		
		System.out.println(result);
		
	}
	
	public void getNthResult(int productNumber) {
		
		String xpathExpression = String.format("//div[@id='srp-river-results']/ul/li[%d]", productNumber);
				
		 String nthProduct = driver.findElement(By.xpath(xpathExpression)).getText();
		 
		 System.out.println(nthProduct);
	}
	
	public void getAllProducts() throws IOException {
		File file1 = new File("out.txt");
		
		FileWriter fw = new FileWriter(file1);
		
		PrintWriter pw = new PrintWriter(fw);

		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li/div/div[2]/a/h3"));
		List<WebElement> allProducts2 = driver.findElements(By.xpath("//div[@id='srp-river-results']/ul/li/div/div[2]/div[3]/div[1]/span"));

		Iterator<WebElement> iteratorAllProducts = allProducts.iterator();
		Iterator<WebElement> iteratorAllProducts2 = allProducts2.iterator();

		while(iteratorAllProducts.hasNext() && iteratorAllProducts2.hasNext()) {
			WebElement product = iteratorAllProducts.next();
			WebElement product2 = iteratorAllProducts2.next();
			
			pw.println(product.getText() + " - " + product2.getText());
		}
		pw.close();
	}

	public void invokeBrowserT() {
		driver = init();
		driver.get("https://www.target.com/");
	}
	
	public void searchProductT (String product)	{
		driver.findElement(By.xpath("//input[@name='searchTerm']")).sendKeys(product);
		driver.findElement(By.xpath("//button[@class='SearchInputButton-sc-1opoijs-0 eOzuAz']")).click();
	}
	
	public void first3Products() throws IOException {
		
		File file1 = new File("out.txt");
		FileWriter fw = new FileWriter(file1);
		PrintWriter pw = new PrintWriter(fw);

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement wait1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='Row-uds8za-0 jBYETz h-padding-t-tight']/li/div/div/div/div/div/div/div/a[@class='Link__StyledLink-sc-4b9qcv-0 styles__StyledTitleLink-h3r0um-1 iBIqkb rwewC h-display-block h-text-bold h-text-bs']")));
		WebElement wait2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='Row-uds8za-0 jBYETz h-padding-t-tight']/li/div/div/div/div/div/div[@class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 igwRHc']/div/div/span")));
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//ul[@class='Row-uds8za-0 jBYETz h-padding-t-tight']/li/div/div/div/div/div/div/div/a[@class='Link__StyledLink-sc-4b9qcv-0 styles__StyledTitleLink-h3r0um-1 iBIqkb rwewC h-display-block h-text-bold h-text-bs']"));
		List<WebElement> allProducts2 = driver.findElements(By.xpath("//ul[@class='Row-uds8za-0 jBYETz h-padding-t-tight']/li/div/div/div/div/div/div[@class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 igwRHc']/div/div/span"));
		
		Iterator<WebElement> iteratorAllProducts = allProducts.iterator();
		Iterator<WebElement> iteratorAllProducts2 = allProducts2.iterator();

		while(iteratorAllProducts.hasNext() && iteratorAllProducts2.hasNext()) {
			WebElement product = iteratorAllProducts.next();
			WebElement product2 = iteratorAllProducts2.next();
			System.out.println(product.getAttribute("innerHTML") + " - " + product2.getAttribute("innerHTML"));
			pw.println(product.getText() + " - " + product2.getText());
		}
		
		
		//Only works for 3 products first row
		WebDriverWait wait5 = new WebDriverWait(driver, 10);
		  WebElement wait6 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Col-favj32-0 sc-jSgupP jkeqlL eVYAHa']/div/ul/li/div/div/div/div/div/div/div/div[@class='h-display-flex']/a")));
		  WebElement wait7 = wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Col-favj32-0 sc-jSgupP jkeqlL eVYAHa']/div/ul/li/div/div/div/div/div/div/div[@class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 igwRHc']/div/div/span")));
		  
		  List<WebElement> allProducts4 = driver.findElements(By.xpath("//div[@class='Col-favj32-0 sc-jSgupP jkeqlL eVYAHa']/div/ul/li/div/div/div/div/div/div/div/div[@class='h-display-flex']/a")); 
		  List<WebElement> allProducts5 = driver.findElements(By.xpath("//div[@class='Col-favj32-0 sc-jSgupP jkeqlL eVYAHa']/div/ul/li/div/div/div/div/div/div/div[@class='styles__ProductCardPriceAndPromoStyled-sc-1p9w55v-0 igwRHc']/div/div/span"));
		  
		  Iterator<WebElement> iteratorAllProducts4 = allProducts4.iterator();
		  Iterator<WebElement> iteratorAllProducts5 = allProducts5.iterator();
		  
		  while(iteratorAllProducts4.hasNext() && iteratorAllProducts5.hasNext()) {
		  WebElement product4 = iteratorAllProducts4.next(); WebElement product5 =
		  iteratorAllProducts5.next();
		  System.out.println(product4.getAttribute("innerHTML") + " - " +
		  product5.getAttribute("innerHTML")); pw.println(product4.getText() + " - " +
		  product5.getText()); }
		
		pw.close();
	}
	
}
