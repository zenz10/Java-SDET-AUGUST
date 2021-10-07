package utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import test.BaseTest;

//screenshot setup
public class SuiteListener implements ITestListener, IAnnotationTransformer{



	public void onTestStart(ITestResult result) {


	}

	public void onTestSuccess(ITestResult result) {


	}

	public void onTestFailure(ITestResult result) {
		String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(f, new File(fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

	public void onStart(ITestContext context) {


	}

	public void onFinish(ITestContext context) {


	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyser.class);
	}
}
