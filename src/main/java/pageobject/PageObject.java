package pageobject;

import org.openqa.selenium.support.PageFactory;

import com.epam.decorator.CustomFieldDecorator;

import driver.Driver;
import testdata.TestData;

public class PageObject {
	PageObject() {
		PageFactory.initElements(new CustomFieldDecorator(Driver.getDriver()), this);

	}
}
