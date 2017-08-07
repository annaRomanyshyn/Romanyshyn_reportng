package com.epam.decorator;

import org.openqa.selenium.WebElement;

public class WrapperFactory {

	public static PageElement createInstance(Class<PageElement> clazz, WebElement element) {
		try {
			return clazz.getConstructor(WebElement.class).newInstance(element);
		} catch (Exception e) {
			throw new AssertionError("WebElement can't be represented as " + clazz);
		}
	}
}
