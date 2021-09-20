package com.techbee.selenium.demo2;
import java.io.IOException;
import org.testng.annotations.Test;

public class ebaytest extends base {

	@Test
	public static void main(String[] args) throws IOException {
			base ebayProject = new base();
			ebayProject.invokeBrowser();
			ebayProject.searchProduct("iPhone", "Cell Phones & Accessories");
			ebayProject.getAllProducts();
		}
	}


