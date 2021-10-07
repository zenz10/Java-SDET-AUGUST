package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import utils.Constants;

public class Steps {
	public HomePage hp;
	public ProductsPage pp;
	public static WebDriver driver;
	
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {

		//uses driver manager
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}else {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver_win32.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User clicks on Spend & Save")
	public void user_clicks_on_spend_save() {
		hp = new HomePage(driver);
		hp.clickOnSpendSave();
	}
	
	@Then("Our products page should be displayed")
	public void our_products_page_should_be_displayed() {
		pp = new ProductsPage(driver);
		pp.findProducts("Aspiration", "Aspiration Plus");
	}

	@When("User clicks on Get Aspiration")
	public void user_clicks_on_get_aspiration() {
		pp.clickGetAspiration();
	}

	@Then("Get Aspiration email input is displayed")
	public void get_aspiration_email_input_is_displayed() {
		pp.clickGetAspirationFillInput("inputcheck");

	}

	@When("User clicks on top right X")
	public void user_clicks_on_top_right_x() {
		pp.exitGetAspirationPopup();
	}

	@Then("User is brought back to our products page")
	public void user_is_brought_back_to_our_products_page() {
		pp.findProducts("Aspiration", "Aspiration Plus");
	}

	@When("User clicks on Get Aspiration Plus")
	public void user_clicks_on_get_aspiration_plus() {
		pp.clickGetAspirationPlus();
	}

	@Then("Yearly and Monthly Plan is displayed")
	public void yearly_and_monthly_plan_is_displayed() {
		pp.VerifyYearlyAndMonthlyPlan("$71.88 paid once yearly", "$7.99 paid monthly");
		driver.close();
		driver.quit();
	}
	
}
