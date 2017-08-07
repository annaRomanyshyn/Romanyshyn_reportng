package com.epam.decorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;

public class Input extends PageElement {

	public Input(WebElement webElement) {
		super(webElement);

	}

	public void sendKeys(String keysToSend) {
		webElement.sendKeys(keysToSend);

	}

	public void click() {
		new WebDriverWait(Driver.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(webElement));
		new Actions(Driver.getDriver()).moveToElement(webElement).click().perform();

	}

}
