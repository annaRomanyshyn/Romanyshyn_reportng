package com.epam.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element extends PageElement {

	public Element(WebElement webElement) {
		super(webElement);

	}

	public WebElement findElement(By by) {

		return webElement.findElement(by);
	}

	public String getText() {
		return webElement.getText();
	}
}
