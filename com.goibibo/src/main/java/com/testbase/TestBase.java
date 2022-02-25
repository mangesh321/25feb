package com.testbase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.Pages;
import com.utility.PropertiesUtils;

public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static ExtentReports report;
	public static ExtentTest test;
	public static ExtentSparkReporter spark;

	public static WebDriver initilisation() {

		log.info("initializing browser");
		String browser = PropertiesUtils.getProperty("browser");
        log.info(browser + " browser is initialized");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver97.exe");
			driver = new ChromeDriver();

		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		log.info("browser is maximized");
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.getProperty("url"));
		log.info("load is apply over a browser");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}

	public void reportInit() {

		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/report/ExtentReports.html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}

	public String takescreanshot(String name) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screanshot/"+name+".jpg";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
		

	}
	public Pages loadPage(){
		Pages pg = new Pages(driver);
		return pg;
	}

	

}
