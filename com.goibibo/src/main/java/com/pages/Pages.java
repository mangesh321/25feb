package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility_class;

public class Pages extends Utility_class {

	WebDriver driver;
	Actions actions;

	public Pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='radio']")
	private WebElement Radiobtn;

	@FindBy(xpath = "//input[@aria-autocomplete='list']")
	private WebElement City;

	@FindBy(xpath = "//div[contains(text(), 'Check-in')]")
	private WebElement checkin;

	@FindBy(xpath = "//span[@data-testid='date_24_2_2022']")
	private WebElement Date1;

	@FindBy(xpath = "//span[@data-testid='date_26_2_2022']")
	private WebElement Date2;

	@FindBy(xpath = "//span[contains(text(), 'Guests & Rooms')]")
	private WebElement Rooms;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[1]/div/span[2]")
	private WebElement addRoomCount;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[2]/div/span[2]")
	private WebElement addAdultCount;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[3]/div/span[2]")
	private WebElement addChildCount;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/section[1]/div[1]/div[2]/div[4]/div/div/div/div[4]/div")
	private WebElement child1Age;

	@FindBy(xpath = "//button[contains(text(), 'Done')]")
	private WebElement Done;
	
	@FindBy(xpath = "//button[contains(text(), 'Search Hotels')]")
	private WebElement SearchHotel;


	public boolean Hotelsearch() throws AWTException, InterruptedException {
		Radiobtn.click();

		System.out.println("Select city Goa ");
		City.sendKeys("Goa");
		Robot();
		Thread.sleep(4000);

		System.out.println("select checkin and checkout date");
		checkin.click();
		Date1.click();
		Date2.click();
		Robot();

		System.out.println("select rooms");
		Rooms.click();
		Robot();

		actions = new Actions(driver);
		System.out.println("select no. of room ");
		actions.click(addRoomCount).build().perform();

		System.out.println("select total no. of person");
		actions.click(addAdultCount).perform();

		System.out.println("select no. of child");
		actions.doubleClick(addChildCount).perform();

		System.out.println("select child age");
		actions.click(child1Age).perform();

		boolean enable = child1Age.isEnabled();

		if (enable == true) {
			System.out.println("Enable as expected");
		} else {
			System.out.println("Disabled ");

		}
		System.out.println("room book done");
		Done.click();
		
		System.out.println("search hotels");
		SearchHotel.click();
		
		

		return true;
	}

}
