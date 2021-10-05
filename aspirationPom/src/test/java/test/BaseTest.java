package test;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageEvents.HomePageEvents;
import pageEvents.ProductsPageEvents;
import utils.Constants;

public class BaseTest {

	public static WebDriver driver;
	public ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeTest
	public void beforeTestMethod() {
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "AutomationReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Aquila Choi");
	}
	
	@BeforeMethod
	@Parameters(value= {"browserName"})
	public void beforeMethodMethod(String browserName, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void aspirationTestmethod() {
		HomePageEvents homePageEvents = new HomePageEvents();
		homePageEvents.clickOnSpendSave();
		
		ProductsPageEvents productsPageEvents = new ProductsPageEvents();
		productsPageEvents.findProducts();
		productsPageEvents.clickGetAspirationFillInput();
		productsPageEvents.exitGetAspirationPopup();
		productsPageEvents.clickGetAspirationPlus();
		productsPageEvents.VerifyYearlyAndMonthlyPlan();
	}
	
	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Skipped";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			logger.log(Status.SKIP, m);
		}
		driver.close();
		driver.quit();
	}
	
	@AfterTest
	public void afterTestMethod() {
		extent.flush();
	}
	
	public void setupDriver(String browserName) {
		//uses driver manager
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
//		using local exe files
//		if(browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver" + File.separator + "chromedriver_win32.exe");
//			driver = new ChromeDriver();
//		}else if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver" + File.separator + "geckodriver_win64.exe");
//			driver = new FirefoxDriver();
//		}else {
//			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "msedgedriver" + File.separator + "msedgedriver_win32.exe");
//			driver = new EdgeDriver();
//		}
	}
}
