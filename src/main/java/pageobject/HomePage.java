package pageobject;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.decorator.Button;
import com.epam.decorator.Element;
import com.epam.decorator.Input;

import driver.Driver;

public class HomePage extends PageObject {
	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
	private Button composeButton;

	@FindBy(css = ".oj div textarea")
	private Input emailInput;

	@FindBy(css = "div.aoD.hl")
	private Button enteredEmail;

	@FindBy(xpath = "//div[@class='vM']")
	private Button deleteEmail;

	@FindBy(name = "subjectbox")
	private Input subjectInput;

	@FindBy(css = ".Ar.Au div ")
	private Input messageInput;

	@FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
	private Button sendButton;

	@FindBy(css = "body > div.Kj-JD > div.Kj-JD-Jl > button")
	private Button errorWindowOkButton;

	@FindBy(xpath = "//*[@id=\"gbqfq\"]")
	private Input searchInput;

	@FindBy(xpath = "//*[@id=\"gbqfb\"]")
	private Button searchButton;

	@FindBy(css = "tr.zA.yO")
	private List<Element> sentEmailsList;

	public void composeClick() {
		composeButton.click();
	}

	public void writeEmailsData(String email, String subject, String message) {
		emailInput.sendKeys(email);
		subjectInput.sendKeys(subject);
		messageInput.sendKeys(message);

	}

	public void sendButtonClick() {
		sendButton.click();
	}

	public void errorWindowOkButtonClick() {
		errorWindowOkButton.click();
	}

	public void deleteEnteredEmailAddress() {
		new WebDriverWait(Driver.getDriver(), 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aoD.hl")));
		enteredEmail.click();
		emailInput.click();
		deleteEmail.click();
	}

	public void goToSentEmails() {
		searchInput.click();
		searchInput.sendKeys("in:sent");
		searchButton.click();

	}

	public List<Element> getSentEmailsList() {
		return sentEmailsList;
	}

	public List getEmailsOfRecieversList() {
		new WebDriverWait(Driver.getDriver(), 40)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ae4.UI")));
		List emailsOfRecievers = new ArrayList();
		for (Element el : getSentEmailsList()) {
			emailsOfRecievers.add(el.findElement(By.cssSelector("span.yP")).getAttribute("email"));

		}
		return emailsOfRecievers;

	}

	public List getSubjectsOfRecieversEmailsList() {
		List subjectsOfRecievers = new ArrayList();
		for (Element el : getSentEmailsList()) {
			subjectsOfRecievers.add(el.findElement(By.cssSelector("span.bog")).getText());

		}
		return subjectsOfRecievers;

	}

}