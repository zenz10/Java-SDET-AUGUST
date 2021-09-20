package com.aspirations.project.aspirationsproject;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;





public class aspirationstest extends base{
	private static Logger log = Logger.getLogger(base.class);

	@Test
	public static void main(String[] args) {
			base aspirationProject = new base();
			aspirationProject.invokeBrowser();
			aspirationProject.searchProduct();
			aspirationProject.findProduct();
			if (aspirationProject.inputField())
			{
				log.info("Input field works");
			}
			else
			{
				log.info("Input field does not work"); 
			}
			aspirationProject.closeinput();
		
			if (aspirationProject.radiobutton())
			{
				log.info("Plan appears");
			}
			else
			{
				log.info("Plan does not appear");
			}
			aspirationProject.wait10();
			aspirationProject.verifyPlan();
			aspirationProject.quit();
	}
}
