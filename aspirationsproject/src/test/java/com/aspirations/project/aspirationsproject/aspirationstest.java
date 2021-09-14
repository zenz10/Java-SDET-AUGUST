package com.aspirations.project.aspirationsproject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class aspirationstest extends base{
	
	@Test
	public static void main(String[] args) {
			base aspirationProject = new base();
			aspirationProject.invokeBrowser();
			aspirationProject.searchProduct();
			aspirationProject.findProduct();
			if (aspirationProject.inputField())
			{
				System.out.println("Input field works");
			}
			else
			{
				System.out.println("Input field does not work");
			}
			aspirationProject.closeinput();
			
			if (aspirationProject.radiobutton())
			{
				System.out.println("Plan appears");
			}
			else
			{
				System.out.println("Plan does not appear");
			}
			aspirationProject.verifyPlan();
	}
	
}
