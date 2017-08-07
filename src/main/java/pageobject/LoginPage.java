package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.decorator.Button;
import com.epam.decorator.CustomFieldDecorator;
import com.epam.decorator.Input;

import driver.Driver;

public class LoginPage extends PageObject {
	WebDriver driver;
	@FindBy(name = "identifier")
	private Input loginInput;

	@FindBy(id = "identifierNext")
	private Button identifierNextButton;

	@FindBy(name = "password")
	private Input passwordInput;

	@FindBy(id = "passwordNext")
	private Button buttonNext;

	public void typeLoginAndSubmit(String login) {
		loginInput.sendKeys(login);
		identifierNextButton.click();

	}

	public void typePasswordAndSubmit(String password) {
		passwordInput.sendKeys(password);
		buttonNext.click();

	}

}
