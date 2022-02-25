package com.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_class {

	WebDriver driver;
	WebDriverWait wait;

	public Utility_class(WebDriver driver) {
		this.driver = driver;
	}

	public void selectOption(String text, WebElement elem) {
		Select dropdown = new Select(elem);
		dropdown.selectByVisibleText(text);

	}

	public void Robot() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
}
