package com.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.pages.Pages;
import com.testbase.TestBase;

public class Test extends TestBase {

	WebDriver driver;

	@BeforeSuite
	public void setup() {
		driver = initilisation();
		loadPage();
		reportInit();
	}

	@org.testng.annotations.Test
	public void verify_search_hotel() throws AWTException, InterruptedException {
		Pages pg = new Pages(driver);
		pg.Hotelsearch();
		Assert.assertTrue(true);

	}

	@AfterSuite
	public void setupclose() {
		driver.close();
	}
}