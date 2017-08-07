package bussinessobj;

import java.util.List;

import models.EmailModel;
import pageobject.HomePage;


public class HomePageBO {
	HomePage home = new HomePage();

	public void clickCompose() {
		home.composeClick();
	}
	
	public void sendEmail(EmailModel email) {
		home.writeEmailsData(email.getEmailTo(), email.getSubject(), email.getMessage());
		home.sendButtonClick();
	}

	public void closeErrorAndClearEmailInput() {
		home.errorWindowOkButtonClick();
		home.deleteEnteredEmailAddress();
	}

	public boolean verifyMessageisSent(EmailModel email) {
		boolean isSent = false;
		home.goToSentEmails();
		List emails = home.getEmailsOfRecieversList();
		List subjects = home.getSubjectsOfRecieversEmailsList();
		for (int i = 0; i < emails.size(); i++) {
			if (emails.get(i).equals(email.getEmailTo()) && subjects.get(i).equals(email.getSubject())) {
				isSent = true;

			}

		}
		return isSent;

	}

}
